/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
/**
 *
 * @author Leandro
 */
public class BLTiraAcentos {
   
     
   public String TiraAcentos (String passa){  
      passa = passa.replaceAll("[ÂÀÁÄÃ]","A");  
      passa = passa.replaceAll("[âãàáä]","a");  
      passa = passa.replaceAll("[ÊÈÉË]","E");  
      passa = passa.replaceAll("[êèéë]","e");  
      passa = passa.replaceAll("ÎÍÌÏ","I");  
      passa = passa.replaceAll("îíìï","i");  
      passa = passa.replaceAll("[ÔÕÒÓÖ]","O");  
      passa = passa.replaceAll("[ôõòóö]","o");  
      passa = passa.replaceAll("[ÛÙÚÜ]","U");  
      passa = passa.replaceAll("[ûúùü]","u");  
      passa = passa.replaceAll("Ç","C");  
      passa = passa.replaceAll("ç","c");   
      passa = passa.replaceAll("[ýÿ]","y");  
      passa = passa.replaceAll("Ý","Y");  
      passa = passa.replaceAll("ñ","n");  
      passa = passa.replaceAll("Ñ","N");
      passa = passa.replaceAll("['<>\\|/]","");
      return passa;  
   }  
  

}  