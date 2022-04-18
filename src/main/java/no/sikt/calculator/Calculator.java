package no.sikt.calculator;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Calculator {
    private String values;
    private Integer result;

    public Calculator(String values) {
        Pattern pattern1 = Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE);
	    Matcher matcher1 = pattern1.matcher(values);
        Boolean checker1 = matcher1.find();
        if(checker1) {
            throw new IllegalArgumentException("Input is invalid, should not contain letters!");
        } else {
            this.values = values;
        }
    }

    public boolean isPlus(String s) {
        if(s.equals("+")) {
            return true;
        }
        return false;
    } 
    public boolean isMinus(String s) {
        if(s.equals("-")) {
            return true;
        }
        return false;
    } 
    public boolean isMult(String s) {
        if(s.equals("*")) {
            return true;
        }
        return false;
    } 
    public boolean isDiv(String s) {
        if(s.equals("/")) {
            return true;
        }
        return false;
    } 

    public boolean isMathOperator(String s) {
        if(s.equals("/")) {
            return true;
        }
        if(s.equals("*")) {
            return true;
        }
        if(s.equals("-")) {
            return true;
        }
        if(s.equals("+")) {
            return true;
        }
        
        return false;
    }

    public boolean onlyDigits(String str, int n){

        for (int i = 0; i < n; i++) {
  
            if (str.charAt(i) >= '0'
                && str.charAt(i) <= '9') {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }



  

    public void CalculateLength7() {
        List<String> list = new ArrayList<>();
        for(String s : this.values.replace("  "," ").split(" ")) {
            list.add(s);
        }

        if(isMathOperator(list.get(3)) && isMathOperator(list.get(4)) && isMathOperator(list.get(5))  && isMathOperator(list.get(6))) {
            throw new IllegalArgumentException("Expression consisting of 7 inputs can not contain 4 math operators!");
        }

        if(isMathOperator(list.get(2)) && isMathOperator(list.get(3)) && isMathOperator(list.get(4)) && isMathOperator(list.get(5))  && isMathOperator(list.get(6))) {
            throw new IllegalArgumentException("Expression consisting of 7 inputs can not contain 5 math operators!");
        }

        if(isMathOperator(list.get(3)) && isMathOperator(list.get(5)) && isMathOperator(list.get(6))) {
            if(isPlus(list.get(3)) && isPlus(list.get(5)) && isPlus(list.get(6))) {
                this.result = Integer.parseInt(list.get(0)) + (Integer.parseInt(list.get(1)) + Integer.parseInt(list.get(2)) + Integer.parseInt(list.get(4)));
            }
            if(isPlus(list.get(3)) && isPlus(list.get(5)) && isMinus(list.get(6))) {
                this.result = Integer.parseInt(list.get(0)) - (Integer.parseInt(list.get(1)) + Integer.parseInt(list.get(2)) + Integer.parseInt(list.get(4)));
            }
            if(isPlus(list.get(3)) && isPlus(list.get(5)) && isMult(list.get(6))) {
                this.result = Integer.parseInt(list.get(0)) * (Integer.parseInt(list.get(1)) + Integer.parseInt(list.get(2)) + Integer.parseInt(list.get(4)));
            }
            if(isPlus(list.get(3)) && isPlus(list.get(5)) && isDiv(list.get(6))) {
                this.result = Integer.parseInt(list.get(0)) / (Integer.parseInt(list.get(1)) + Integer.parseInt(list.get(2)) + Integer.parseInt(list.get(4)));
            }
        } 
        else {
            throw new IllegalArgumentException("Math operator is wronlgy positioned!");
        }        
    }

    

    public void CalculateLength5() {
        List<String> list = new ArrayList<>();
        for(String s : this.values.replace("  "," ").split(" ")) {
            list.add(s);
        }
        if(isMathOperator(list.get(2)) && isMathOperator(list.get(3)) && isMathOperator(list.get(4))) {
            throw new IllegalArgumentException("Expression consisting of 5 inputs can not contain 3 math operators!");
        }

 
        if(isMathOperator(list.get(2)) && isMathOperator(list.get(4))) {
            
            if(isPlus(list.get(2)) && isPlus(list.get(4))) {
                this.result = Integer.parseInt(list.get(0)) + Integer.parseInt(list.get(1)) + Integer.parseInt(list.get(3));
            }
            if(isPlus(list.get(2)) && isMinus(list.get(4))) {
                this.result = Integer.parseInt(list.get(0)) + Integer.parseInt(list.get(1)) - Integer.parseInt(list.get(3));
            }
            if(isPlus(list.get(2)) && isMult(list.get(4))) {
                this.result = (Integer.parseInt(list.get(0)) + Integer.parseInt(list.get(1))) * Integer.parseInt(list.get(3));
            }
            if(isPlus(list.get(2)) && isDiv(list.get(4))) {
                this.result = (Integer.parseInt(list.get(0)) + Integer.parseInt(list.get(1))) / Integer.parseInt(list.get(3));
            }


            if(isMinus(list.get(2)) && isPlus(list.get(4))) {
                this.result = Integer.parseInt(list.get(0)) - Integer.parseInt(list.get(1)) + Integer.parseInt(list.get(3));
            }
            if(isMinus(list.get(2)) && isMinus(list.get(4))) {
                this.result = Integer.parseInt(list.get(0)) - Integer.parseInt(list.get(1)) - Integer.parseInt(list.get(3));
            }
            if(isMinus(list.get(2)) && isMult(list.get(4))) {
                this.result = (Integer.parseInt(list.get(0)) - Integer.parseInt(list.get(1))) * Integer.parseInt(list.get(3));
            }
            if(isMinus(list.get(2)) && isDiv(list.get(4))) {
                this.result = (Integer.parseInt(list.get(0)) - Integer.parseInt(list.get(1))) / Integer.parseInt(list.get(3));
            }


            if(isMult(list.get(2)) && isPlus(list.get(4))) {
                this.result = Integer.parseInt(list.get(0)) * Integer.parseInt(list.get(1)) + Integer.parseInt(list.get(3));
            }
            if(isMult(list.get(2)) && isMinus(list.get(4))) {
                this.result = Integer.parseInt(list.get(0)) * Integer.parseInt(list.get(1)) - Integer.parseInt(list.get(3));
            }
            if(isMult(list.get(2)) && isMult(list.get(4))) {
                this.result = (Integer.parseInt(list.get(0)) * Integer.parseInt(list.get(1))) * Integer.parseInt(list.get(3));
            }
            if(isMult(list.get(2)) && isDiv(list.get(4))) {
                this.result = (Integer.parseInt(list.get(0)) * Integer.parseInt(list.get(1))) / Integer.parseInt(list.get(3));
            }


            if(isDiv(list.get(2)) && isPlus(list.get(4))) {
                this.result = Integer.parseInt(list.get(0)) / Integer.parseInt(list.get(1)) + Integer.parseInt(list.get(3));
            }
            if(isDiv(list.get(2)) && isMinus(list.get(4))) {
                this.result = Integer.parseInt(list.get(0)) / Integer.parseInt(list.get(1)) - Integer.parseInt(list.get(3));
            }
            if(isDiv(list.get(2)) && isMult(list.get(4))) {
                this.result = (Integer.parseInt(list.get(0)) / Integer.parseInt(list.get(1))) * Integer.parseInt(list.get(3));
            }
            if(isDiv(list.get(2)) && isDiv(list.get(4))) {
                this.result = (Integer.parseInt(list.get(0)) / Integer.parseInt(list.get(1))) / Integer.parseInt(list.get(3));
            } 
        }

        else if(isMathOperator(list.get(3)) && isMathOperator(list.get(4))) {
            if(isPlus(list.get(3)) && isPlus(list.get(4))) {
                this.result = Integer.parseInt(list.get(0)) + (Integer.parseInt(list.get(1)) + Integer.parseInt(list.get(2)));
            }
            if(isPlus(list.get(3)) && isMinus(list.get(4))) {
                this.result = Integer.parseInt(list.get(0)) - (Integer.parseInt(list.get(1) + Integer.parseInt(list.get(2))));
            }
            if(isPlus(list.get(3)) && isMult(list.get(4))) {
                this.result = (Integer.parseInt(list.get(0)) * (Integer.parseInt(list.get(1)) + Integer.parseInt(list.get(2))));
            }
            if(isPlus(list.get(3)) && isDiv(list.get(4))) {
                this.result = (Integer.parseInt(list.get(0)) / (Integer.parseInt(list.get(1)) + Integer.parseInt(list.get(2))));
            }


            if(isMinus(list.get(3)) && isPlus(list.get(4))) {
                this.result = Integer.parseInt(list.get(0)) + (Integer.parseInt(list.get(1)) - Integer.parseInt(list.get(2)));
            }
            if(isMinus(list.get(3)) && isMinus(list.get(4))) {
                this.result = Integer.parseInt(list.get(0)) - (Integer.parseInt(list.get(1)) - Integer.parseInt(list.get(2)));
            }
            if(isMinus(list.get(3)) && isMult(list.get(4))) {
                this.result = (Integer.parseInt(list.get(0)) * (Integer.parseInt(list.get(1)) - Integer.parseInt(list.get(2))));
            }
            if(isMinus(list.get(3)) && isDiv(list.get(4))) {
                this.result = (Integer.parseInt(list.get(0)) / (Integer.parseInt(list.get(1)) - Integer.parseInt(list.get(2))));
            }


            if(isMult(list.get(3)) && isPlus(list.get(4))) {
                this.result = Integer.parseInt(list.get(0)) + (Integer.parseInt(list.get(1)) * Integer.parseInt(list.get(2)));
            }
            if(isMult(list.get(3)) && isMinus(list.get(4))) {
                this.result = Integer.parseInt(list.get(0)) - (Integer.parseInt(list.get(1)) * Integer.parseInt(list.get(2)));
            }
            if(isMult(list.get(3)) && isMult(list.get(4))) {
                this.result = (Integer.parseInt(list.get(0)) * (Integer.parseInt(list.get(1)) * Integer.parseInt(list.get(2))));
            }
            if(isMult(list.get(3)) && isDiv(list.get(4))) {
                this.result = (Integer.parseInt(list.get(0)) / (Integer.parseInt(list.get(1)) * Integer.parseInt(list.get(2))));
            }


            if(isDiv(list.get(3)) && isPlus(list.get(4))) {
                this.result = Integer.parseInt(list.get(0)) + (Integer.parseInt(list.get(1)) / Integer.parseInt(list.get(2)));
            }
            if(isDiv(list.get(3)) && isMinus(list.get(4))) {
                this.result = Integer.parseInt(list.get(0)) - (Integer.parseInt(list.get(1)) / Integer.parseInt(list.get(2)));
            }
            if(isDiv(list.get(3)) && isMult(list.get(4))) {
                this.result = (Integer.parseInt(list.get(0)) * (Integer.parseInt(list.get(1)) / Integer.parseInt(list.get(2))));
            }
            if(isDiv(list.get(3)) && isDiv(list.get(4))) {
                this.result = (Integer.parseInt(list.get(0)) / (Integer.parseInt(list.get(1)) / Integer.parseInt(list.get(2))));
            }
        } else {
            throw new IllegalArgumentException("Math operators are wronlgy positioned!");
        }

    }

    public void CalculateLength3() {
        List<String> list = new ArrayList<>();
        for(String s : this.values.replace("  "," ").split(" ")) {
            list.add(s);
        }
        if(!(Integer.parseInt(list.get(0)) == (int)Integer.parseInt(list.get(0)))) {
            throw new IllegalArgumentException("First input has to be a number!");
        } 
        if(!(Integer.parseInt(list.get(1)) == (int)Integer.parseInt(list.get(1)))) {
            throw new IllegalArgumentException("Second input has to be a number!");
        }
        if(isMathOperator(list.get(2))) {
            if(isPlus(list.get(2))) {
                this.result = Integer.parseInt(list.get(0)) + Integer.parseInt(list.get(1));
            }
            if(isMinus(list.get(2))){
            this.result = Integer.parseInt(list.get(0)) - Integer.parseInt(list.get(1));
            }
            if(isDiv(list.get(2))){
                this.result = Integer.parseInt(list.get(0)) / Integer.parseInt(list.get(1));
            }
            if(isMult(list.get(2))){
                this.result = Integer.parseInt(list.get(0)) * Integer.parseInt(list.get(1));
            }
        } else {
            throw new IllegalArgumentException("Math operator is wronlgy positioned!");
        }        
    }

    public Integer getResult() {
        List<String> list = new ArrayList<>();
        for(String s : this.values.replace("  "," ").split(" ")) {
            list.add(s);
        }

        int size = list.size();
      
        if(list.isEmpty()) {
            throw new IllegalArgumentException("There is no input!");
        }
        if(list.size() == 0) {
            throw new IllegalArgumentException("There is no input!");
        }
        if(!(this.values.contains(" ")) && this.values.split("").length > 3) {
            throw new IllegalArgumentException("Every number/operator should be provided with empty field after it!");
        }
        if(size < 3) {
            throw new IllegalArgumentException("Input is to short!");
        }
        if(size > 7) {
            throw new IllegalArgumentException("Too many values!");
        }
        if(size == 6) {
            throw new IllegalArgumentException("Expression has to consist of 3, 5 or 7 inputs!");
        }
        if(size == 4) {
            throw new IllegalArgumentException("Expression has to consist of 3, 5 or 7 inputs!");
        }
        if(onlyDigits(this.values, values.length()) && list.stream().filter(v -> isMathOperator(v) == true).findAny().isEmpty()){
            throw new IllegalArgumentException("Input is invalid, should contain math operators!");
        }
        if(isMathOperator(list.get(0))) {
            throw new IllegalArgumentException("First position can not be math operator!");
        }
        if(isMathOperator(list.get(1))) {
            throw new IllegalArgumentException("Second position can not be math operator!");
        }
        

        

        if(size == 3) {
            CalculateLength3();
        }
        if(size == 5) {
            CalculateLength5();
        }  
        if(size == 7) {
            CalculateLength7();
        }   
        
        return this.result;
    } 

    public String toString() {
        return this.result.toString();
    }
}
