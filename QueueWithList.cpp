#include <iostream>
using namespace std;

struct Node
{
    int data;
    Node *next;
};

struct Queue
{
    Node *front = nullptr; // Corrected front pointer declaration
    Node *rear = nullptr;  // Rear pointer to track the last node

    // Enqueue operation (add element at the rear)
    void enqueue(int data)
    {
        Node *temp = new Node;
        temp->data = data;
        temp->next = nullptr;

        if (front == nullptr) // If queue is empty, both front and rear point to the new node
        {
            front = temp;
        }
        else
        {
            rear->next = temp; // Link the new node to the rear
        }
        rear = temp; // Update rear to the new node
    }

    // Dequeue operation (remove element from the front)
    int dequeue()
    {
        if (front == nullptr) // Check if queue is empty
        {
            cout << "Queue underflow" << endl;
            return -1;
        }
        int result = front->data; // Get data from the front node
        Node *temp = front;
        front = front->next; // Move front to the next node
        delete temp; // Free the memory of the dequeued node

        if (front == nullptr) // If the queue becomes empty, rear should also be nullptr
        {
            rear = nullptr;
        }

        return result;
    }
};

int main()
{
    Queue q;
    cout<<"Queue using List:"<<endl ;
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    q.enqueue(4);

    cout << q.dequeue() << endl;
    cout << q.dequeue() << endl;
    cout << q.dequeue() << endl;
    cout << q.dequeue() << endl;
    cout << q.dequeue() << endl; // This will trigger Queue underflow

    return 0;
}
