package com.spam.controller;
import java.io.IOException;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spam.bean.User;
import com.spam.util.HetuKryptaaja;
import com.spam.util.SendMail;

@Controller
@RequestMapping(value = "/")
public class HetuController {
	
	 //muuttujat
	 String LopullinenHetu=null;
	 String crypted=null;
	
	  //Kysytään hetua käyttäjältä
		@RequestMapping(value = "/hetu/luo", method = RequestMethod.GET)
		public String sentHetu(Model model) throws IOException {
			
			model.addAttribute("LopullinenHetu", LopullinenHetu);
			return "hetuLaskuri";
		}

		// Lasketaan hetu saaduista parametreistä
		@RequestMapping(value = "/hetu/laske", method = RequestMethod.POST)
		public String getHetu(@RequestParam("paiva") int paiva,@RequestParam("kuukausi") int kuukausi,@RequestParam("vuosi") int vuosi) {
			
			Map<Integer, String> hetuMap = new HashMap<>();
			hetuMap.put(0, "0");
			hetuMap.put(1, "1");
			hetuMap.put(2, "2");
			hetuMap.put(3, "3");
			hetuMap.put(4, "4");
			hetuMap.put(5, "5");
			hetuMap.put(6, "6");
			hetuMap.put(7, "7");
			hetuMap.put(8, "8");
			hetuMap.put(9, "9");
			hetuMap.put(10, "A");
			hetuMap.put(11, "B");
			hetuMap.put(12, "C");
			hetuMap.put(13, "D");
			hetuMap.put(14, "E");
			hetuMap.put(15, "F");
			hetuMap.put(16, "H");
			hetuMap.put(17, "J");
			hetuMap.put(18, "K");
			hetuMap.put(19, "L");
			hetuMap.put(20, "M");
			hetuMap.put(21, "N");
			hetuMap.put(22, "P");
			hetuMap.put(23, "R");
			hetuMap.put(24, "S");
			hetuMap.put(25, "T");
			hetuMap.put(26, "U");
			hetuMap.put(27, "V");
			hetuMap.put(28, "W");
			hetuMap.put(29, "X");
			hetuMap.put(30, "Y");
			
			//laskee viimeisen merkin
			String hetu = new StringBuilder().append(paiva).append(kuukausi).append(vuosi).toString();
			
			Random rn = new Random();
			Integer hetuNumero = rn.nextInt(899 - 002 + 1) + 002;
			Integer hetuNumeroJaettu=hetuNumero%31;

			String hetuConvert=new StringBuilder().append(hetu).append("-").append(hetuNumero).toString();
			String viimeinenMerkki=null;			
			if(hetuMap.containsKey(hetuNumeroJaettu)) {
				
				for (Map.Entry<Integer, String> entry : hetuMap.entrySet()) {

					if(entry.getKey().equals(hetuNumeroJaettu)) {
						viimeinenMerkki=entry.getValue();
						LopullinenHetu=new StringBuilder().append(hetuConvert).append(viimeinenMerkki).toString();
	
						//Kryptattu hetu
						HetuKryptaaja sk = new HetuKryptaaja();
						crypted=sk.crypted(LopullinenHetu);

					}

				}
				
			}

			
			System.out.println("generoitu hetusi on: "+LopullinenHetu);
			System.out.println("generoitu hetusi on: "+crypted);	
		  
			return "redirect:/hetu/luo";
		}
	

}