#include <iostream>
#include <thread>

int const SIZE = 10;

using namespace std;

void addArrays(float* array1,float* array2,float* targetArray){
    for (int i = 0; i < SIZE; i++) {
        targetArray[i] = array1[i] + array2[i];
    }
}

int main() {
    float array1[SIZE] = { 1.1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    float array2[SIZE] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
    float addedArray[SIZE];

    thread t(addArrays,  array1, array2, addedArray  );
    t.join();

    cout << "Rezultat: ";
    for (int i = 0; i < SIZE; i++) {
        cout << addedArray[i] << " ";
    }
    cout << endl;

    return 0;
}
