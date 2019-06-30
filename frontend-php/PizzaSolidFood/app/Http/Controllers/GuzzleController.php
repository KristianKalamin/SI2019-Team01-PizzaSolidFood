<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use GuzzleHttp\Client;
use GuzzleHttp\Exception\BadResponseException;

class GuzzleController extends Controller
{
    public function getRemoteData(){
        

        $client = new \GuzzleHttp\Client();
        $response = $client->request('GET', 'http://localhost:8088/psf-rest/auth/login');

        echo $response->getStatusCode(); # 200
        echo $response->getHeaderLine('content-type'); # 'application/json; charset=utf8'
        echo $response->getBody(); # '{"id": 1420053, "name": "guzzle", ...}'
        

    }
}
