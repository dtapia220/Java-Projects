public class App {
    public static void main(String[] args) throws Exception {
      //  System.out.println("Hello, World!");

       


          System.out.println( removeOuterParentheses("(())"));

        
    }
        
        public static String removeOuterParentheses(String s) {
                
                //declares len in assigns the length of string s
                int len = s.length();
                
                // Checks if the length is less than or equal to 2 and if it is than returns ""
                if (len <= 2) return "";
                
                //splits the string of s int the char[] c array
                char[] c = s.toCharArray();
                
                //creates new string
                StringBuilder newString = new StringBuilder();
                
                //declares variables
                int open = 1;
                //int openLeft = 0;
                
                //For Loop goes through the length of the string
                for (int i = 1; i < len; i++) {
                    //checks if the c[i] is equal to ( if it is than it increments open
                    if (c[i] == '(') {
                        open++;
            
                        if (open > 1) newString.append('(');
                    }
                    
                    else {
                    //checks if the c[i] is equal to ) if it is than it increments open
                        if (open > 1) newString.append(')');
                        open--;
                        
                    }
                }
                // outputs newString.toString
                return newString.toString();
            }
        
        
        


    
}


