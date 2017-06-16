<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    <link rel="stylesheet" href="/resources/js/slider/pageSwitch.min.css">
    <style type="text/css" media="screen">
        .sections,
        .section {
            height: 100%;
        }
        
        #container,
        .sections {
            position: relative;
        }
        
        .section {
            background-color: #000;
            text-align: center;
            color: white;
        }
        
        #container {
            width: 100%;
            height: 100%;
            overflow: hidden;
        }
        
        .pages.horizontal {
            width: 100%;
            text-align: center;
            bottom: 5px;
        }
        
        .sections h3 {
            position: absolute;
            z-index: 99999;
            padding: 6px 8px;
            background: none repeat scroll 0 0 #000000;
            cursor: default;
            text-align: left;
            font-size: 14px;
            left:0;
            bottom: 12%;
            opacity: .7;
            filter:alpha(opacity=70);  
        }
        
        .sections h3 a {
            color: #fff;
        }
    </style>
    <div id="container">
        <div class="sections">
        </div>
    </div>