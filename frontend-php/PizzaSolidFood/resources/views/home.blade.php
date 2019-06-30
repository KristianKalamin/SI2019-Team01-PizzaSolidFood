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
    <header class="fixed">
        <div class="container c2r1">
            <div class="title">
                <img src="icon/pizza.svg" height="40px" width="40px">
                <h1>Pizza Solid Food</h1>
            </div>
            <nav>
                <ul>
                    <li><a href="#welcome">Home</a></li>
                    <li><a href="#menu-content">Menu</a></li>
                    <li><a href="#gallery-content">Gallery</a></li>
                    <li><a href="#our-story">About Us</a></li>
                    <li><a href="#contact">Contact</a></li>
                    <li><a href="
                    
                    @if(Session::get('status') == 'Logged')
                    {{ url('/profile')}}
                    @else
                    {{ url('/signup') }}
                    @endif
                    
                    "class="sign-up">
                    @if(Session::get('status') == 'Logged')
                    {{ Session::get('userName') }} {{ Session::get('lastName') }}
                    @else
                    Sign Up
                    @endif
                    </a></li>
                </ul>
                <div class="menu-trigger"><i class="fas fa-bars"></i></div>
            </nav>
        </div>
    </header>
    <section id="title-image">
        <div class="container">
            <div class="header-content">
                <h2>Pizza Solid Food</h2>
                <h4>30 years of experience Direct to you!</h4>
            </div>
        </div>
        <div class="bg-image"></div>
        <div class="mask"></div>
    </section>
    <section id="welcome">
        <div class="container c2r1">
            <div class="welcome-text">
                <h2>Welcome</h2>
                <h3>to our restaurant</h3>
                <p>Pizza Solid Food serves pizza and seasonal fare with a focus on fresh, local ingredients. Opened by native New Yorkers, the concept was born by friends whose vision was to provide the neighborhood with delicious comfort food in a cozy, intimate setting.</p>
            </div>
            <div class="welcome-image">
                <img src="../img/home/menu-restaurant-vintage-table.jpg" alt="">
            </div>
        </div>
    </section>
    <section id="our-team">
        <div class="container">
            <div class="title">
                <h2>Our Team</h2>
            </div>
            <div class="team">
                <div class="first-member">
                    <img src="../img/home/First.png" alt="">
                    <h3>Arman Kibee</h3>
                </div>
                <div class="second-member">
                    <img src="../img/home/Second.png" alt="">
                    <h3>Jamey Giovannini</h3>
                </div>
                <div class="third-member">
                    <img src="../img/home/Third.png" alt="">
                    <h3>Hervey Troutman</h3>
                </div>
                <div class="fourth-member">
                    <img src="../img/home/Fourth.png" alt="">
                    <h3>Tamarra Garber</h3>
                </div>
                <div class="fifth-member">
                    <img src="../img/home/Fifth.png" alt="">
                    <h3>Rosana Finley</h3>
                </div>
                <div class="sixth-member">
                    <img src="../img/home/Sixth.png" alt="">
                    <h3>Salome Calkins</h3>
                </div>
            </div>
        </div>
    </section>
    <section id="menu-content">
        <div class="bg-image"></div>
        <div class="mask"></div>
        <div class="container">
            <div class="title">
                <h2>MENU</h2>    
            </div>
            <div class="menu">
                @if(count($pizza) > 1)
                    @foreach($pizza as $pizzas)
                        <article>
                            @php $filename = $pizzas['productName'] . '.jpg' @endphp
                            
                            <img src="{{ asset('storage/' .$filename) }}" alt="pizza image">
                            <h2> {{ $pizzas['productName'] }} </h2>
                            <br>
                            <br>
                            <br>
                            <br>
                            <a class="order-btn" href=" {{ url('/product/' .$pizzas['idProd']) }}">Order</a>
                        </article>
                    @endforeach
                @endif
            </div>
        </div>
    </section>
    <section id="gallery-content">
        <div class="container">
            <div class="title">
                <h2>Gallery</h2>
            </div>
            <div class="gallery">
                <div class="image" id="image1">
                    
                </div>
                <div class="image" id="image2">
                    
                </div>
                <div class="image" id="image3">
                    
                </div>
                <div class="image" id="image4">
                    
                </div>
                <div class="image" id="image5">
                    
                </div>
                <div class="image" id="image6">
                    
                </div>
            </div>
        </div>
    </section>
    <section id="our-story">
        <div class="container">
            <div class="content">
                <div class="our-story">
                    <h2>Our Story</h2>
                    <p>Italian cuisine restaurant Pizza Solid Food is located in the heart of Belgrade, in Dorćol district, the old city neighborhood known for its multicultural atmosphere. Restaurant owner himself has been actively engaged in decorating the restaurant interior and the smallest details were taken into account, wrought iron wine cellar, painted walls, a small gallery with a few tables, discreet home lighting lamps, comfortable chairs, so your stay would be as pleasant as possible. Restaurant terrace offers all possibilities for a pleasant stay and relaxation during and after the working day, and refreshments to all those who have decided to spend the day sightseeing Belgrade</p>
                </div>
            </div>
        </div>
    </section>

    <section id="about-us">
        <div class="bg-image"></div>
        <div class="mask"></div>
        <div class="container">
            <div class="content">
                <div class="about-us">
                    <h2>About</h2>
                    <p>It's difficult to tell the story of Dorćol that would be totally acceptable and concievable, but we will try our best to bring you closer to rich history, spirit and ambience of this area, and Belgrade as well. Although without set borders, it is considered that Dorćol covers the northern part and the lower town of Kalemegdan, and the area between the streets of kneza Mihaila and the Danube River. The name of the neighborhood comes from Turkish words dört (four) and yol (road), literally meaning "four roads" or colloquially "intersection (of four roads)", "crossroads". These were the roads to Istanbul, Vidin, Sever, and probably Dubrovnik. During the Turkish occupation of Belgrade, Dorćol was a well known trading centre, with many markets and traders of different nationalities. Also, it was a center of Belgrade's Jewish community, remnant of which is the modern Jevrejska ("Jewish") street in Dorćol. After Belgrade became a capital of independent Serbia, Dorćol kept its multinational character for a long time. Over time the old low houses and narrow streets were changed into modern buildings. Still, some parts, though vanishing one by one, resemble the old look. Dorćol is a location of some of the oldest city buildings. The oldest surviving private house in downtown Belgrade that is still used as a residence is located in the Dorćol district</p>
                </div>
            </div>
        </div>
    </section>
    <section id="contact">
        <div class="bg-image"></div>
        <div class="mask"></div>
        <div class="title">
            <div class="container">
                <h2>Contact</h2>
            </div>
        </div>
        <div class="container">
            <div class="contact-content">
                <div class="text">
                    <h2>We'd love to hear from you</h2>
                    <p>While we're good with smoke signals, there are simpler ways for us to get in touch and answer your questions. To get in touch with the Pizza Solid Food team simply fill out the contact form. Alternatively you can telephone us on 02 9251 5600 or email us at restaurant@psf.com </p>
                </div>
                <form action="#">
                    <input type="text" placeholder="E-mail address">
                    <br>
                    <input type="text" placeholder="Name">
                    <br>
                    <input type="text" placeholder="Subject">
                    <br>
                    <textarea name="" id="" cols="30" rows="10" placeholder="Message"></textarea>
                    <br>
                    <input type="button" value="Submit">
                </form>
            </div>
        </div>
    </section>
    
    <section id="our-location">
        <div class="title">
            <div class="container">
                <h2>Our Location</h2>
            </div>
        </div>
        <div class="mapouter"><div class="gmap_canvas"><iframe width="100%" height="500" id="gmap_canvas" src="https://maps.google.com/maps?q=zrenjanin&t=&z=17&ie=UTF8&iwloc=&output=embed" frameborder="0" scrolling="no" marginheight="0" marginwidth="0"></iframe><a href="https://www.emojilib.com">emojilib.com</a></div><style>.mapouter{position:relative;text-align:right;height:500px;width:100%;}.gmap_canvas {overflow:hidden;background:none!important;height:500px;width:100%;}</style></div>
    </section>
    <footer>
        <div class="container">
            <div class="content">
                <div class="left-side">
                    <h2>Newsletter</h2>
                    <h3>Be first to know</h3>
                    <input type="email" placeholder="Your e-mail address">
                    <br>
                    <input type="button" value="Subscribe">
                </div>
                <div class="middle">
                    <h2>Pizza Solid Food</h2>
                    <h3>Social networks</h3>
                    <div class="social">
                        <a href=""><i class="fab fa-facebook"></i></a>
                        <a href=""><i class="fab fa-instagram"></i></a>
                        <a href=""><i class="fab fa-twitter"></i></a>
                    </div>
                </div>
                <div class="right-side">
                    <h2>Opening hours</h2>
                    <h4><span class="bold">Monday-Friday</span> 8AM-11PM</h4>
                    <h4><span class="bold">Saturday</span> 8AM-01PM</h4>
                    <h4><span class="bold">Sunday</span> 10AM-10PM</h4>
                </div>
            </div>
            <div class="copyright">
                <h4>&copy; 2019 Pizza Solid Food. All Rights Reserved.</h4>
            </div>
        </div>
    </footer>
    
    <script src="js/jquery.js"></script>
    
    <script type="text/javascript" src="js/responsive-menu.js">
    </script>
    
</body>

</html>