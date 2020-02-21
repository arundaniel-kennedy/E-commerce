<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
  
<title>AboutUs</title>
<style>

.background
{
   height: 700px;
   background-image: url("resources/images/book8.jpg");
   background-repeat: no-repeat;
   background-size: 100%;
}

.style
{
    font-style: italic;

}

</style>
</head>
<body>
<%@include file="Header.jsp"%>

<div class="background">
<h3 class="style">Who We Are</h3>

<p>ReadersDesk is the world’s largest site for readers and book recommendations. 
Our mission is to help people find and share books they love. Goodreads launched in January 2007.</p>

<h3 class="style">A Few Things You Can Do On ReadersDesk</h3>

<p>See what books your friends are reading.
Track the books you're reading, have read, and want to read.
Check out your personalized book recommendations. Our recommendation engine analyzes 20 billion data points to give suggestions
 tailored to your literary tastes.
Find out if a book is a good fit for you from our community’s reviews.</p>

<h3 class="style">A Message From Our CEO and Co-Founder</h3>

<p>When I was in second grade, I discovered the Hardy Boys series. Ever since, I've loved to read — both for fun and to improve my mind.
 And I'm always looking for the next great book.

One afternoon while I was scanning a friend's bookshelf for ideas, it struck me: when I want to know what books to read,
 I'd rather turn to a friend than any random person or bestseller list.

So I decided to build a website – a place where I could see my friends' bookshelves and learn about what they thought of all their books. 
Elizabeth, my co-founder (and now my wife) wrote the site copy and I wrote the code. We started in my living room, 
motivated by the belief that there was a better way to discover and discuss good books, and that we could build it.

ReadersDesk is that site. It is a place where you can see what your friends are reading and vice versa. 
You can create "bookshelves" to organize what you've read (or want to read). 
You can comment on each other's reviews. You can find your next favorite book. And on this journey with your friends
 you can explore new territory, gather information, and expand your mind. 

Knowledge is power, and power is best shared among readers.</p>

<%@ include file="Footer.jsp" %>
</div>
</body>
</html>