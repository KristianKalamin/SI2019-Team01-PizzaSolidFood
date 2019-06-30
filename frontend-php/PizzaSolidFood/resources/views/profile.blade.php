<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Pizza Solid Food</title>
    <link rel="icon" href="icon/pizza.png">
    <link href="css/all.css" rel="stylesheet">
    <script defer src="js/all.js"></script>
    <link rel="stylesheet" href="css/app.css">
</head>


<body>
    <header>
        <div class="container c2r1">
            <div class="title">
                <img src="icon/pizza.svg" height="40px" width="40px">
                <h1>Pizza Solid Food</h1>
            </div>
            <nav>
                <ul>
                    <li><a href="{{url('/')}}">Home</a></li>
                </ul>
                <div class="menu-trigger"><i class="fas fa-bars"></i></div>
            </nav>
        </div>
    </header>
    
    <section id="profile-content">
        <div class="profile">
            @if(Session::get('status') == 'Logged')
            <div class="icon"></div>
            <h2> {{ Session::get('userName') }} {{ Session::get('lastName') }} </h2>
            <div class="info">
            <div class="info-block"><h5>Email: {{ Session::get('email') }}  </h5></div>
            
            <div class="info-block"><h5>
            
            User type:
            @if(Session::get('userType') == 0)
             Normal 
            @elseif(Session::get('userType') == 1)
             Premium
            @elseif(Session::get('userType') == 2)
             Admin
            @endif
            
            </h5></div>
            <div class="info-block"><h5>Points: {{ Session::get('Points') }}  </h5></div>
            <a class="sign-out" href="{{url('/signout')}}">Sign Out</a>
            @else
            <h2> You are not logged in. </h2>
            @endif
            </div>
        </div>
    </section>

    
    <script src="js/jquery.js"></script>
    
    <script type="text/javascript" src="js/responsive-menu.js">
    </script>
    
</body>

</html>