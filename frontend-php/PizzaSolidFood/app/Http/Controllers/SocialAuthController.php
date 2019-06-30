<?php
 
namespace App\Http\Controllers;
 
use Illuminate\Http\Request;
//use Socialite;
use League\OAuth2\Client\Provider\Google;
use League\OAuth2\Client\Token\AccessToken;
use GuzzleHttp\Exception\ClientException;

use HomeDefaultController;

use Session;

class SocialAuthController extends Controller
{


    public function google() { 

        $provider = new Google([
            'clientId'     => '51577597659-rfksc3t05cegn3jq7pta6jm42d0qsl0e.apps.googleusercontent.com',
            'clientSecret' => 'ZN3nv0LC8ZNmsRb87O71CHHS',
            'redirectUri'  => 'http://localhost:8000/google',
            ]);

        if (!empty($_GET['error'])) {

            // Got an error, probably user denied access
            exit('Got error: ' . htmlspecialchars($_GET['error'], ENT_QUOTES, 'UTF-8'));

        } elseif (empty($_GET['code'])) {

            // If we don't have an authorization code then get one
            $authUrl = $provider->getAuthorizationUrl();
            $_SESSION['oauth2state'] = $provider->getState();
            header('Location: ' . $authUrl);
            exit;

        } else {

            // Try to get an access token (using the authorization code grant)
            $token = $provider->getAccessToken('authorization_code', [
                'code' => $_GET['code']
            ]);

           
            /** @var League\OAuth2\Client\Token\AccessToken $token */
            $values = $token->getValues();

            /** @var string */
            $jwt = $values['id_token'];
            //echo $jwt;
            try {
                $client = new \GuzzleHttp\Client();
                $response = $client->request('POST', 'http://localhost:8080/psf-rest/auth/login', [
                    'headers' => ['Authorization' => 'Bearer '.$jwt]
                ]);

                $contents = $response->getBody()->getContents();
                //print_r($contents);

                $json = json_decode($contents, true);

                $username =  $json['name'];
                $lastname =  $json['lastName'];
                $email =  $json['email'];
                $usertype =  $json['userType'];
                $points =  $json['points'];
                $status = 'Logged';

                session(['userName' => $username]);
                session(['lastName' => $lastname]);
                session(['userType' => $usertype]);
                session(['email' => $email]);
                session(['Points' => $points]);
                session(['status' => $status]);
                
                
                
                return redirect()->action('HomeDefaultController@home');
            } catch(ClientException  $e) {
                return redirect()->route('signup');
            }
            
            
        }
    }
}