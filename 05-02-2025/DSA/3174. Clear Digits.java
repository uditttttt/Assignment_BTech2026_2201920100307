class Solution {
  public String clearDigits(String s) {
      StringBuilder sb1 = new StringBuilder();
      for(int i=0; i<s.length(); i++){
          if(Character.isDigit(s.charAt(i))){ 
              sb1.deleteCharAt( sb1.length()-1 );
          }else{
              sb1.append(s.charAt(i));
          }
      }

      return sb1.toString();
  }
}