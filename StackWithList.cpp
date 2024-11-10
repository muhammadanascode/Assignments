#include <iostream>
using namespace std;

//stack using linked-list
struct Node
{
    int data;
    Node *next;
};

struct Stack
{
    Node *top = nullptr;

    void push(int data)
    {
        Node *temp = new Node;
        temp->data = data;
        temp->next = top;
        top = temp;
    }

    int pop()
    {
        if (top == nullptr)
        {
            cout<<"Stack underflow"<<endl ;
            return -1;
        }
        int result = top->data;
        top = top->next;
        return result;
    }
};

int
main()
{
    Stack *s  =new Stack ;
    s->push(1);
    s->push(2);
    s->push(3);
    s->push(4);

    cout << s->pop()<<endl;
    cout << s->pop()<<endl;
    cout << s->pop()<<endl;
    cout << s->pop()<<endl;
    cout << s->pop()<<endl;

    return 0;
}