package RecursCompf;
interface StackCalc {
    //Добавить число в стек.
    void push(int val);
    //Показать вершину стека.
    int top() throws Exception;
    //Сложить.
    int add() throws Exception;
    //Вычесть.
    int sub() throws Exception;
    //Умножить.
    int mul() throws Exception;
    //Разделить.
    int div() throws Exception;
}