<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

use Session;
use Auth;
use HomeDefaultController;

class Signout extends Controller
{
    public function signout(){
        Session::flush();
        Auth::logout();
        return redirect()->action('HomeDefaultController@home');
    }
}
