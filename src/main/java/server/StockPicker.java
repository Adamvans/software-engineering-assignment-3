/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.net.*;
import java.io.*;
/**
 *
 * @author dexter
 */
public class StockPicker 
{
    //---------------------------------------------------------------------------------
    //returns a -1 on failure
    public double getStockPrice (String symbol) throws Exception
    {
        //set the address
        URL address;
        address = new URL("https://finance.yahoo.com/quote/" + symbol);
        BufferedReader in = new BufferedReader(new InputStreamReader(address.openStream()));
        
        //get the input from the page
        // format <title>AAPL 191.61 0.17 0.09% : Apple Inc. - Yahoo Finance</title>
        String inputLine;
        String tag;
        double price = -1;
        
        while ((inputLine = in.readLine()) != null)
        {
            //error checking
            if (inputLine.length() < 6)
            {
                continue;
            }
            if (inputLine.equalsIgnoreCase ("<title></title>"))
            {
                System.out.println ("Not a valid stock symbol");
                return -1;                        
            }
            
            //logic for each line
            tag = inputLine.substring(0,6);
            if (tag.equalsIgnoreCase("<title>"))
            {
                price = parseToDouble (inputLine);
                break;
            }
        }
        in.close();
        
        return price;
    }
    //-----------------------------------------------------------------------------
    private double parseToDouble (String toParse)
    {
        int start = 0;
        int end = 0;
        
        for (int i = 0; i < toParse.length(); i++)
        {
            // format <title>AAPL 191.61 0.17 0.09% : Apple Inc. - Yahoo Finance</title>
            if ((start) == 0 && (toParse.charAt(i) == '1' || toParse.charAt(i) == '2' || 
                    toParse.charAt(i) == '3' || toParse.charAt(i) == '4' || toParse.charAt(i) == '5' ||
                    toParse.charAt(i) == '6' || toParse.charAt(i) == '7' || toParse.charAt(i) == '8' ||
                    toParse.charAt(i) == '9' || toParse.charAt(i) == '0'))
            {
                start = i;
            }
            
            if (start != 0 && toParse.charAt(i) == ' ')
            {
                end = i;
                break;
            }
        }
        
        if (start == 0 && end == 0)
        {
            System.out.println ("The input " + toParse + "did not contain a valid number");
            return -1;
        }
        
        //parse it!
        toParse = toParse.substring(start, end);
        double price;
        try
        {
            price = Double.parseDouble(toParse);
        }
        catch (NumberFormatException e)
        {
            System.out.println ("error in parsing double");
            return -1;
        }
       return price; 
    }
}
