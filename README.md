# GPC Parser

####    Provides REST-API  for parsing '.gpc' file format to Payment object and saves it to (embeded) MongoDB repository.

    REST-API: 
    
    POST:
     path:      /addpayment
     content:   file in gpc format 
   
    DELETE:
    path:       /payments/{paymentID}
    
    GET:
    all payments:
     path:      /payments
     
     one payment:
     path:      /payments/{paymentId}
                
--- 


