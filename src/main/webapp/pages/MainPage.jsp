<%-- 
    Document   : MainPage
    Created on : Aug 6, 2018, 7:45:35 PM
    Author     : dexte
--%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/pages/tester.jsp"></script>
       
        <title>Main Page</title>
        
        <script>    
//            window.onload = function() {
//            var socket = new WebSocket("ws://localhost:8080/SE_A3/server");
//            
//            
//            socket.onopen = function()
//            {
//            };
//            
//            socket.onmessage = function (event)
//            {
//             
//             var totalstock = [];
//             var returnPrice = JSON.parse(event.data);
//             
//            for(var i = 0; i< returnPrice.length; i++)
//            {
//                totalstock.push(stockamount(returnPrice[i]));
//                
//            }
//           
//             grapher(returnPrice,totalstock);
//             
//            };
//            
//            
//            
//           form.onsubmit = function(e) {
//                    e.preventDefault();
//
//  // Retrieve the message from the textarea.
//            var symOne = document.getElementById("symOne").value;
//                 var symTwo = document.getElementById("symTwo").value;
//                 var symThree = document.getElementById("symThree").value;
//
//            var stocks = [symOne, symTwo, symThree];
//  // Send the message through the WebSocket.
//  
//      
//            var jStocks = JSON.stringify(stocks);
//  
//               socket.send(jStocks);
//               
//                return false;
//                };
//            
//           
//            
//            
//          
//            };
//            
//            
//            function grapher(stockprice, stockamounts)
//            {
//                var symOne = document.getElementById("symOne").value;
//                var symTwo = document.getElementById("symTwo").value;
//                var symThree = document.getElementById("symThree").value;
//                
//                var values = [[symOne, symTwo, symThree],[stockprice[0],stockprice[1],stockprice[2]],[stockamounts[0],stockamounts[1],stockamounts[2]]];
//                
//                
//                var data = [{
//                    type: 'table',
//                    header: {
//                        values: [["Stock Symbol"], ["Price"], ["Amount of Stock"]],
//			align:  "center",
//                    line: {width: 1, color: '#506784'},
//                    fill: {color: '#119DFF'},
//                    font: {family: "Arial", size: 12, color: "white"}
//                    },
//                cells: {
//                values: values,
//                align: ["left", "center"],
//                line: {color: "#506784", width: 1},
//                fill: {color: ['#25FEFD', 'white']},
//                font: {family: "Arial", size: 11, color: ["#506784"]}
//                        }
//                            }];
//
//                Plotly.plot('table', data);
//                
//                
//                
//                
//                var databar = [
//                {
//                    x: [symOne, symTwo, symThree],
//                    y: [stockamounts[0],stockamounts[1],stockamounts[2]],
//                    type: 'bar'
//                }
//                                ];
//
//                Plotly.newPlot('bar', databar);
//                
//                
//                
//                
//                
//                var datapie = [{
//                    values: [stockamounts[0],stockamounts[1],stockamounts[2]],
//                    labels: [symOne, symTwo, symThree],
//                    type: 'pie'
//                    }];
//
//                var layout = {
//                    height: 400,
//                    width: 500
//                };
//
//                Plotly.newPlot('pie', datapie, layout);
//                
//                
//
//            }
//            
//            
//            
//            
//           function stockamount(stockprice)
//           {
//               var amount = document.getElementById('amount');
//               var stocks = amount.value/3/stockprice;
//               
//               
//               var s = stocks.toFixed(2);
//               
//               return s;
//           }
//             
        </script>
        
        
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <p>
        <h2>Instructions:</h2>
        
        <p>
        <h4> 
            <p>
        1. Enter in a starting amount of money
        </p>
        2. Enter in three Stock Symbols and press the start button 
        </h4>
        </p>
            
            
            
        </p>
        
        <div id="userinput">
            <form id="form" action="#" method="post">
            Starting amount of money: <input type="text" id="amount"><br> 
            <br>
            Stock Symbol #1: <input type="text" id="symOne"><br>
            
            Stock Symbol #2: <input type="text" id="symTwo"><br>
            
            Stock Symbol #3: <input type="text" id="symThree"><br>
            
            <button type="submit">Generate</button><br>
            
            </form>
            
  
        </div>
        
        <div id="table"></div>
        <div id="bar"></div>
        <div id="pie"></div>
        
        
        
        
        
        
    </body>
</html>
