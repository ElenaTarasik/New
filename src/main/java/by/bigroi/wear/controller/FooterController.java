package by.bigroi.wear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FooterController {

    @GetMapping("/footer_order")
    public String defaultPage( ) {return "/footerPage/footerOrder";}

    @GetMapping("/footer_payment")
    public String defaultPage1( ) {return "/footerPage/footerPayment";}

    @GetMapping("/footer_delivery")
    public String defaultPage2( ) {return "/footerPage/footerDelivery";}

    @GetMapping("/footer_shipmentPoint")
    public String defaultPage3( ) {return "/footerPage/footerShipmentPoint";}

    @GetMapping("/footer_aboutUs")
    public String defaultPage4( ) {return "/footerPage/footerAboutUs";}

    @GetMapping("/footer_contacts")
    public String defaultPage5( ) {return "/footerPage/footerContacts";}

    @GetMapping("/footer_advantages")
    public String defaultPage6( ) {return "/footerPage/footerAdvantages";}

    @GetMapping("/footer_partners")
    public String defaultPage7( ) {return "/footerPage/footerPartners";}
}


