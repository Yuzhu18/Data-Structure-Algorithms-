ublic class Solution {
  public String hex(int number) {
    if (number == 0) {
      return "0x0";
    }
    
    char[] charArray = {'0', '1', '2', '3', '4', '5', '6', '7', 
                        '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    StringBuilder sb = new StringBuilder("0x");
    boolean isLeadingZero = true;
    
    for (int last_4_bit = 28; last_4_bit >= 0; last_4_bit -= 4) {
      char hex = charArray[(number >> last_4_bit) & 0xF];
      if (hex != '0' || !isLeadingZero) {
        sb.append(hex);
        isLeadingZero = false;
      }
    }    
    return sb.toString();
  }
}
