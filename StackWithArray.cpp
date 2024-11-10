#include <iostream>
using namespace std;

// stack using array

struct Stack
{
    int arr[10];
    int top = -1;

    void push(int data)
    {
        if (top >= 9)
        {
            cout << "Stack overflow";
            return;
        }
        arr[++top] = data;
        return;
    }

    int pop()
    {
        if (top < 0)
        {
            cout << "Stack underflow"<<endl;
            return -1;
        }
        return arr[top--];
    }

};

int
main()
{
    Stack s;
    cout<<"Stack using Array:"<<endl ;
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);

    cout << s.pop()<<endl;
    cout << s.pop()<<endl;
    cout << s.pop()<<endl;
    cout << s.pop()<<endl;
    cout << s.pop()<<endl;
    return 0;
} 

