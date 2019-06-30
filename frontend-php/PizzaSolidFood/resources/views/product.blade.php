<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Pizza Solid Food</title>
    <link rel="icon" href="{{ asset ('icon/pizza.png') }}">
    <link href="{{ asset('css/all.css') }}" rel="stylesheet" type="text/css" >
    <script defer src=" {{ asset('js/all.js') }}"></script>
    <link href="{{ asset('css/app.css') }}" rel="stylesheet" type="text/css" >
</head>


<body>
    <header>
        <div class="container c2r1">
            <div class="title">
                <img src="{{asset ('icon/pizza.svg')}}" height="40px" width="40px">
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
    
    <section id="product-content">
        <div class="product-img">
            @php $filename = $product['productName'] . '.jpg' @endphp
            <img src=" {{ asset('storage/' .$filename) }} " alt="">
        </div>
        <div class="info">
            <h2 class="info-title">Name:</h2>
            <br>
            <h2 class="pizza-name">{{ $product['productName'] }}</h2>
            <br>
            <h2 class="info-title">Addition:</h2>
            <br>
            <div class="custom-select" style="width:200px;">
            <select>
                <option value="">Select addition:</option>
                @foreach($additions as $addition)
                <option value=""> {{ $addition['additionName'] }}</option>
                @endforeach
            </select>
            </div>
            <br>
            <h2 class="info-title">Description:</h2>
            <br>
            <h4> {{ $product['productDescription'] }} </h4>
            <br>
            <h2 class="info-title">Quantity:</h2>
            <br>
            <input type="text" value="0">
            <br>
            <br>
            <h2 class="info-title">Prize: </h2>
            <h2 class="pizza-name">{{ $product['productPrice'] }}</h2>
            <br>
            <a class="order-btn" href="">ORDER</a>
        </div>
    </section>

    
    <script src="{{ asset ('js/jquery.js') }}"></script>
    
    <script type="text/javascript" src="{{ asset ('js/responsive-menu.js') }}">
    </script>
    
</body>

</html>