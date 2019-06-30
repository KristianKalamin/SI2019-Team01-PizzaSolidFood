<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use GuzzleHttp\Exception\ClientException;

class ProductPageController extends Controller
{
    public function productPage($id){
        $productid = $id;
        //echo $id;

        $client = new \GuzzleHttp\Client();
        $response = $client->request('GET', 'http://localhost:8080/psf-rest/public/product/' .$productid);
        $products = $response->getBody()->getContents();

        $response2 = $client->request('POST', 'http://localhost:8080/psf-rest/public/additions');
        $additions = $response2->getBody()->getContents();

        
        //print_r($products);
        //print_r($additions);


        $array = json_decode($products, true);
        $array2 = json_decode($additions, true);


        return view('product')->with('product', $array)->with('additions', $array2);
    }
}
