import React, { Component } from 'react';
//import { CloudinaryContext, Transformation, Image } from 'cloudinary-react';

import './page.css';
import '../Bootstrap/dist/css/sb-admin-2.css'
import axios from 'axios'

class Page extends Component {

  constructor(props) {
      super(props);
      this.state = {
          donnees: []
      }
  }
  componentDidMount() {
       axios.get('http://localhost:8080/type/listeService/')
          .then(res => {
              console.log(res.data.resources);
              this.setState({type: res.data.resources});
      });
  }
  render() {
    return (

      <div className="page">
      Rather than logging the uploaded image information to the console, we update the gallery state, which bears the list of requested images, by concatenating the uploaded result to the gallery.

      Image Management Simplified

      Image uploads, transformation and delivery has never been easier. These tasks have been a serious challenge for developers. Cloudinary has created a way to abstract all this hard work, enabling you to simply plug and play.


      Native's Exponent with Charlie Cheever'


      React Native continues on a development spree in late 2016. With an ambitious two-week release cycle, the framework makes rapid progress towards feature and performance parity with its native Android and iOS equivalents. At the same time, these quick release periods frequently introduce breaking changes, difficulty with setup, and challenges with basic configuration.''

      Enter Exponent, a tool that promises easier setup, development, and deployment of React Native applications. Rather than being a replacement for React Native, as it is sometimes confused, Exponent augments React Native by dramatically simplifying the development and deployment processes. Whereas basic setup with an Android environment to develop with React Native can take over an hour by hand, even for experienced engineers, Exponent shortens the time to start to “Hello World” to a handful of minutes.''

      React Native continues on a development spree in late 2016. With an ambitious two-week release cycle, the framework makes rapid progress towards feature and performance parity with its native Android and iOS equivalents. At the same time, these quick release periods frequently introduce breaking changes, difficulty with setup, and challenges with basic configuration.''

      Enter Exponent, a tool that promises easier setup, development, and deployment of React Native applications. Rather than being a replacement for React Native, as it is sometimes confused, Exponent augments React Native by dramatically simplifying the development and deployment processes. Whereas basic setup with an Android environment to develop with React Native can take over an hour by hand, even for experienced engineers, Exponent shortens the time to start to “Hello World” to a handful of minutes.''

      Exponent’s prime feature is revealed as it’s namesake IDE. The Exponent IDE is development platform for not only developing apps to test in their respective environment simulators, but also simplifies testing them on real devices.''

      One of the cofounders of Exponent, Charlie Cheever, agreed to answer a few questions about Exponent and its purpose in the community.''


      Hi, Charlie. Congrats on the release of Exponent! One of the toughest aspects of Exponent is understanding what its purpose is. What is the primary goal of Exponent?''

      Thanks :)''

      Before I worked on mobile software, I spent about 15 years making websites. When I started working on the Quora iPhone app and Android app, it felt like time traveling back to 1993. So many things to worry about that have nothing to do with the product you want to build.''

      One thing we’re trying to do with Exponent is making it as easy to develop native mobile apps as it is to make websites, or even easier! I think about how I learned to build software as a kid–making games on my TI-85 and making Hypercard stacks–and I want to make it so that the middle school kids of today can make cool stuff for themselves and their friends.''

      Basic environment setup of the iOS and Android simulators for developing React Native apps is commonly cited as a headache by new developers. What does Exponent do to alleviate this pain?''

      The biggest thing that Exponent does is take care of everything related to native code for you. So you don’t need to know Swift/Obj-C/Java or even have Xcode or Android Studio to be able to write React Native apps. You write just JavaScript and Exponent has everything else already setup for you.''

      Since you don’t write any native code with Exponent, just JavaScript, Exponent has a lot of the most popular native modules built in. Native maps, push notifications, Facebook and Google login, camera and camera roll access, contacts, TouchID, and a native video player are all included among other things. We’re always adding more of these as well. We just added full OpenGL support last week and did a game jam and made some mini games with it and are adding sound soon.''

      We sometimes talk about Exponent as being like Rails for React Native. You could write a website in Ruby on your own. but Rails sets up a bunch of sensible things right off that bat that work together in a coherent way and we kind of do the same thing for React Native. Exponent includes instant app updating as a default, so you can deploy new code and assets with one command in seconds, even faster than most websites can be deployed.''

      Even after getting set up with the Android and iOS simulators, testing a React Native app on a real phone can still be a challenge. How does Exponent make it easier to share apps in progress with would-be users?''

      You can actually open any Exponent project that you’re working on in our development app right away. When you develop with Exponent, you get a URL for your project, and you can open that URL on any phone with the Exponent developer app which you can download from the iOS App Store or Google Play Store. You don’t need to jack your phone into your computer–just open the URL.''

      Another really cool thing about this is that, if you’re working with someone else, you can just send them the URL and they can open it on their phone as well, even if they are halfway around the world.''

      We’ve done a bunch of work to make this pretty nice, like having console.log work even if the phone running your code isn’t plugged into your computer. And you can, of course, open your project on the iOS Simulator or an Android Emulator as well if you prefer.''

      I know you mentioned a lot of people have trouble getting React Native setup on Android especially. With Exponent, every project works on both iOS and Android from the start and you never have to deal with Android Studio, so the process of getting going is much easier.''

      What type, or genre, of application would be a good fit with React Native and Exponent?''

      I would actually use React Native for almost any mobile app at this point. Doing development the traditional way (writing Swift/Java/Obj-C code) is just too hard to iterate on when you consider the slowness of the code-compile-copy-run loop and the fact that you have to write your app twice (and then keep it in sync!). The other thing that is an absolutely huge deal here but is sometimes overlooked is the layout engine. It’s much easier to build and change a layout in React Native’s Flexbox than any of the UI libraries that I’ve seen for Java/Swift/Obj-C.''

      And if you need to do something really intense, like Snapchat live video filters, you can just write your own code as a native module and write the rest of your app in JS.''

      I would use Exponent for anything I could because it just saves a lot of time and headaches since you don’t need to deal with Android Studio or Xcode. Some people don’t know that you can turn an Exponent project into an app store app for iOS or for Android with just one command.''

      In general, Exponent will work for you in pretty much every case where just having a mobile website is one of the things that you’re considering. The features are pretty equivalent except that Exponent apps feel like native apps and mobile apps still feel like mobile web apps.''

      The main reason not to use Exponent is if you have some custom native code that you need that isn’t included with Exponent. The most common reasons that people can’t use Exponent are if they need use Bluetooth or HealthKit or something else low level that isn’t built in to Exponent; or if they need to integrate into an existing project (though we are working right now on a solution that will let you do this).''

      The exception to all this is games. If you are making a mobile game, Unity is probably the best choice for you. But we did add OpenGL support to Exponent recently and had a game jam and I was surprised at how good some of the entries were, so I think that might change.''

      TL;DR: For apps that aren’t games, always use React Native (if you need to do something super custom, just do it as a native module). If you can, use Exponent (you can most of the time but check our docs to make sure we’re not missing anything you need).''

      One aspect of React Native that seems to be undergoing constant flux is its solution for navigation. Between the built in Navigators and open source solutions, do you have any thoughts on an ideal solution for navigation?''

      Short version: I think you should use Ex-Navigation that Adam Miskiewicz (skevy) and Brent Vatne on our team wrote. Skevy in particular has been thinking about navigation in mobile apps and React Native for a long time. Using Ex-Navigation is definitely a better idea than Navigator or NavigatorIOS.''

      To make things confusing, there is also NavigatorExperimental (yes, that’s different from Ex-Navigation) and ExNavigator (which was made by James Ide and Ex-Navigation is based on). The good news is that everyone working on these problems got together and decided to merge them all together. I don’t know how long that is going to take but it will probably be released sometime in the next few months under the name React Navigation, and that should unify everyone’s efforts!''

      There is also this other school of thought where some people like to use the platform-specific native code for navigation which is the approach that the Wix Navigator uses. I have a strong personal view that its preferable to write UI components like this in JS because I actually think you want your app to be the same across iOS and Android (they are both just black rectangles with touch screens!) and JS tends to make your code more composable and customizable.''

      Use Ex-Navigation and keep an eye out for React Navigation! Use JS instead of native for this UI code!''

      Given the increasingly fast development and deployment times, handling API setup for dealing with data is becoming a large obstacle to React Native apps. Do you have any thoughts about the use of Backend-As-A-Service solutions like Firebase compared to rolling your own API with Node/Express, Rails, or similar?''

      I don’t have a strongly held view on this right now. There are so many solutions that fit the use cases of people with different needs. We’re seeing things getting easier and easier in every direction that you look.''

      If you want to write your own code and you’re using JS, you can use something like Zeit’s new now stuff to deploy essentially instantly. If you want a more general purpose solution, Heroku is also really easy. And then of course there is AWS and Google Cloud, etc.''

      It’s trivially easy for React Native apps to communicate with essentially any backend that uses HTTP/JSON since fetch and JSON.parse are built-in.''

      If you don’t want to write any code, it seems like Firebase has become the most popular solution since Parse announced its shutdown. One nice thing about Firebase is that you can use their hosted database stuff with React Native using just JS, which means it works just fine with Exponent. Someone wrote up a guide to how to do this here: https://gist.github.com/sushiisumii/d2fd4ae45498592810390b3e05313e5c'

      Longer term, it seems like something like GraphQL/Relay should become really popular, but that stuff is too hard to setup and use still to be mainstream just yet. I’m not sure whether it will be GraphQL/Relay maturing and getting revised that wins or something else that is slightly different and easy to think about as a developer that comes and beats it, but directionally, it’s definitely right. We built something like this at Quora and it saved a ton of development time.''

      I would just use whatever you are most comfortable with – almost anything will work! React Native is really similar to the the web in terms of its client capabilities and so I would just think about a React Native or Exponent app as being mostly like a website.''


      Routing in React Native with Jake Murzy'


      Jake Murzy has been hard at work creating a new navigational library for React Native over the last couple of months. While React JS has the benefit of the highly-regarded React Router, such a comprehensive routing solution doesn’t exist yet in the React Native community. In fact, React Native’s routing landscape has been in constant upheaval for the last year. The library itself has official three ‘navigators’ for handling decision making on which components to show the user, including ‘NavigatorIOS’, ‘Navigator’, and - more recently - ‘NavigatorExperimental’. The open source community likewise has the packages ‘React Native Router Flux’, ‘React Native Router Native’, and ‘React Native Redux Router’, which of which are in various states of completion, or, more commonly, disrepair.''

      Jake Murzy has been hard at work creating a new navigational library for React Native over the last couple of months. While React JS has the benefit of the highly-regarded React Router, such a comprehensive routing solution doesn’t exist yet in the React Native community. In fact, React Native’s routing landscape has been in constant upheaval for the last year. The library itself has official three ‘navigators’ for handling decision making on which components to show the user, including ‘NavigatorIOS’, ‘Navigator’, and - more recently - ‘NavigatorExperimental’. The open source community likewise has the packages ‘React Native Router Flux’, ‘React Native Router Native’, and ‘React Native Redux Router’, which of which are in various states of completion, or, more commonly, disrepair.''

      React Router Native appears to focus on matching the API of the immensely popular React Router package, even going as far as introducing the concept of a URL into React Native, which bucks the notion that only web applications need or deserve a URL.''


      Today Jake is going to share some of his thoughts about his new library.''

      Q: Hi Jake! The React Native library contains several navigation solutions and the surrounding ecosystem has multiple routing libraries. What made you decide to make your own?''

      Hey! Thanks for reaching out. I’ve been eagerly watching what’s happening with navigation on React Native for a while. Until very recently, the whole Navigation scene in React Native was a mess. Navigator was being deprecated in favor of NavigationExperimental and NavigationExperimental wasn’t ready for prime time.''

      My team was just starting a new project so I tried quite a few of the available solutions. Having successfully used React Router on the web, we were looking for a similar solution. Unfortunately, React Router did not support React Native, and other solutions we found were either very unstable, had a hard time keeping up with upstream changes on each release or the quality of code was quite poor.''

      NavigationExperimental did most of what we wanted but it was a bit too low level so often times we found ourselves writing navigation related code and you can imagine how this gets tedious fast. The low level nature of NavigationExperimental is really by design to allow abstractions to be built up in higher layers. So to finally answer your question, the project came directly out of my frustration trying to make navigation work on React Native as good as React Router did on the web.''

      Q: What is the strength of your routing system? Is there any type of app that would be a perfect fit with React Router Native? Conversely, is there any type of app that wouldn’t be a good fit with the library?''

      The use cases for React Router Native is pretty much the same as NavigationExperimental—which is the only supported navigation library by the React Native team. React Router Native is a very thin layer on top of NavigationExperimental that offers React Router’s mental model in a native app. Under the hood, it uses React Router for routing and NavigationExperimental for rendering user components. This is a very powerful combination that makes URLs possible on mobile.''

      Most apps do not have deep-linking capabilities because implementing it for each screen in your app is a challenging task. Even within apps, users are often forced to take screenshots to share information. And for many, it’s vital that their apps support deep-linking. For example, Yelp goes as far to show a share prompt when users take screenshots of business listings. React Router Native enables developers to implement deep-linking in their apps without putting forth much effort. This can pave the way for a more connected app ecosystem.''

      That being said, we’re still in the early days of React Native figuring out the right abstractions. Navigation on mobile is a challenging task, and having different flavors is only healthier as the community weighs the pros and cons of each approach rather than second guessing best-practices. So I’m hoping to get the community involved to shape the direction of the project.''

      Q: Is React Router Native designed to be used with any of the official Navigation components written by the React Native team?''

      Absolutely. One of the primary goals of the project is that we follow React’s “learn once, write anywhere” principle. So you can use the community maintained components, interpolators and pan responders from React Native, and everything is highly customizable if you need instruct NavigationExperimental to do fancy transition animations, etc.''

      Q: The React Router team has somewhat famously rewritten their API several times in the last two years, each time introducing several breaking changes. Do you hope to keep your library at parity with React Router, breaking changes and all? Case in point, the V4 release of React Router will introduce an all-new API.''

      React Router v4 is a complete rewrite. There was a lot of head-scratching on Twitter over the entire new set of breaking changes. Many people thought v4 should at best have been released under a different name. I’m not sure if I agree with that sentiment though, I understand where it is coming from. React Router v4 is a preview release, and in my opinion, it’s really hard to argue against replacing a foreign API with simple React components. I do hope to keep the library at parity with React Router, and to be honest, v4’s new everything-is-a-component approach makes the integration even easier. So over the next few weeks I’ll be working on v4 support.''

      Q: If you were new to React Native, which routing solution would you use? Why?''

      This is a hard one to answer. Eric Vicenti has done a great job on NavigationExperimental and most of the issues have been sorted out by the community over the last few months. So if you’re familiar with Redux concepts and comfortable writing your own reducers to manage navigation state, NavigationExperimental is a great choice.''

      One that I’m surprised you didn’t mention that deserves more attention is ExNavigation—another fairly new addition to the brewery. It also uses NavigationExperimental and is maintained by Adam Miskiewicz, Brent Vatne and other awesome members of the Exponent community. It feels a bit tied to the Exponent platform, but runs perfectly fine on React Native and is open source. So you’ve got that.''

      Finally, If you’re just getting started with React Native and all you need is to be able to click a button and have it transition to a different scene but you don’t want it to get in your way when you need to reach in and apply complex navigational patterns, I strongly recommend you take React Router Native for a spin.''


      Playing With React and D3'


      D3 is great at data visualizations, but it manipulates the DOM directly to display that data. Rendering DOM elements is where React shines. It uses a virtual representation of the DOM (virtual DOM) and a super performant diffing algorithm in order to determine the fastest way to update the DOM. We want to leverage React’s highly efficient, declarative, and reusable components with D3’s data utility functions.''

      At this point, we can safely say that React is the preferred JavaScript library for building user interfaces. It is used practically everywhere and is almost as pervasive as jQuery. It has an API that is simple, powerful, and easy to learn. Its performance metrics are really impressive thanks to the Virtual DOM and its clever diff algorithm between state changes. Nothing, however, is perfect, and React too has its limitations. One of React’s greatest strengths is the ease with which it integrate third-party libraries, but some libraries, especially opinionated ones, are more difficult to integrate than others.''

      An extremely popular library that can be tricky to integrate with React is D3.js. D3 is an excellent data visualization library with a rich and powerful API. It is the gold standard of data visualizations. However, Because this library is opinionated about data, it is no trivial endeavour to get it to work with React. A few simple strategies permit these two libraries to work together in very powerful ways.'

      Editor’s Note: Check out our upcoming workshop, React and D3, a crash course in learning how to create data visualizations with these two in demand libraries. Reserve your spot now on Eventbrite and get 20% off admission. Learn more at the Eventbrite page'
      What is React?'

      React is an open-source JavaScript library for creating user interfaces that addresses the challenges of building large applications with data that changes over time. Originally developed at Facebook, it is now seen in many of the most commonly used web applications including Instagram, Netflix, Airbnb, and HelloSign.'

      Why is React so popular?'

      React helps developers build applications by helping manage the application state. It’s simple, declarative, and composable. React is not a traditional MVC framework because React is really only interested in building user interfaces. Some have called it the “V(iew)” in MVC, but that’s a little misleading. React’s viewpoint is different. As application logic has reoriented toward the client, developers have applied more structure to their front-end JavaScript. We applied a paradigm that we already understood from the server (MVC) to the browser. Of course, the browser environment is very different from the server. React acknowledges that client-side applications are really a collection of UI components that should react to events like user interaction.'

      React encourages the building applications out of self-contained, reusable components that only care about a small piece of the UI. Other frameworks such as Angular also attempt to do this, but React stands out because it enforces a unidirectional data flow from parent component to child component. This makes debugging much easier. Debugging is the hardest part of application development, so while React is more verbose that other libraries or frameworks, in the end it saves a lot of time. In a framework like Angular’s, it can be hard to figure out where a bug is coming from: The view? The model? The controller? The directive? The directive controller? Data in Angular flows in many different directions, and this makes it hard to reason about that state of your application. In React, when there is a bug (and there will be!), you can quickly determine where the bug originated from because data only moves in one direction. Locating a bug is as simple as connecting the numbered dots until you find the culprit.

      What is D3?

      D3 (Data-Driven Documents) is a JavaScript library for producing dynamic, interactive data-visualizations. It’s fairly low level, and the developer has a lot of control over the end result. It takes a bit of work to get D3 to do what you want, so if you’re looking for a more prepackaged solution, you’re probably better off with highcharts.js. That said, it is fairly simple to pick up once you get the hang of it.

      </div>
    );
  }
}

export default Page;
