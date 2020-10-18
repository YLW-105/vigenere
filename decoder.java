public class decoder{
  public static String vigenere(String text, String key, Boolean encode){
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String repeatKey = "";
    int length = text.length() / key.length() ;
    int length2 = text.length() - (length * key.length());
    for(int i = 0; i < length; i++){
      repeatKey = repeatKey + key;
    }
    repeatKey = repeatKey + key.substring(0, length2);

    String result = "";
    int place = 0;
    int place2 = 0;
    int changedIndex = 0;
    for(int k = 0; k < text.length(); k++){
      place = alphabet.indexOf(text.charAt(k));
      place2 = alphabet.indexOf(repeatKey.charAt(k));
      if (encode){
        changedIndex = (place + place2) % 26;
      }
      else {
        if (place - place2 < 0){
        changedIndex = (place - place2) + 26;
      }
        else changedIndex = place - place2;
      }
      result = result + alphabet.charAt(changedIndex);
    }
    return result;
  }
  public static void main (String [] args){
    String action = args[0];
    Boolean encode = true;
    if (action.equals("decode")){
      encode = false;
    }
    String text = args[1].toUpperCase();
    String key = args[2].toUpperCase();
    System.out.println(vigenere(text, key, encode));
  }
}
