package RecursCompf;

public class RecursCompf{
    private static final int DEFSIZE = 256;
    private char[] str;
    private int index; //Число обработанных символов.
    public RecursCompf(){
        str = new char[DEFSIZE];
    }
    private void compileF(){
        compileT();
        if(index >= str.length)
            return;
        while (index < str.length && (str[index] == '+' || str[index] == '-')) {
            if (str[index] == '-') {
                if (index != 0 && str[index - 1] != '[' && str[index - 1] != '{' && str[index - 1] != '(') {
                    index++;
                    compileT();
                    System.out.print("- ");
                }
                else {
                    index++;
                    System.out.print("-");
                    compileF();
                }
            }
            else {
                index++;
                compileT();
                System.out.print(" + ");
            }
        }
    }

    private void compileT() {
        compileM();
        if(index >= str.length)
            return;
        while (index < str.length && (str[index] == '*' || str[index] == '/')) {
            char num = str[index];
            index++;
            compileM();
            System.out.print(" " + num + " ");
        }
    }

    private void compileM(){
        if(index < str.length && (str[index] == '(' || str[index] == '[' || str[index] == '{')){
            char num =  str[index];
            index++;
            compileF();

            if ((num == '(' && str[index] == ')') || (num == '[' && str[index] == ']') || (num == '{' && str[index] == '}'))
                index++;
            else
                throw new RuntimeException("Некорректное расположение скобок");
        }

        else
            compileV();
    }

    private void compileV() {
        if (!Character.isLetter(str[index]) && !Character.isDigit(str[index]))
            System.out.print(" ");

        else {
            if (index == str.length - 1) {
                System.out.print(str[index]);
                System.out.print(" ");
                return;
            }
            System.out.print(str[index++]);
            compileV();
        }
    }

    public void compile(char[] str){
        this.str = str;
        index = 0;
        compileF();
        System.out.print("\n");
    }
}

