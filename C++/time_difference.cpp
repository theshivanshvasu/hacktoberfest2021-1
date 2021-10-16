#include<iostream>
#include <string.h>

using namespace std;


// function that take decimal as parameter and extract its decimal points as minut
int extract_min(float time){

  // declaring integer to store minuts that will be returning
  int minuts;
  // declaring string to store the decimal time as string format
  string s_time;

  // saving decimal time into the string s_time
  s_time = to_string(time);
  // subtracting everything unill a dot come
  s_time = s_time.substr(s_time.find(".") + 1);
  // converting the remaining decimals points back into integer
  // then dividing it by 10000 to make them 2 digits only
  minuts = stoi(s_time)/10000;

  // returning minuts as a return for the function extract_min()
  return minuts;

}

// function that ask user to input a decimal and then returns it
float validate_time(){

  // declaring a float to store the decimal time
  float time;

  // asking for inout and store it in time
  std::cin >> time;

  // loop to ask user to enter again if it enter a character or string
  while (cin.fail() ) {

    std::cout << "Enter a float please please" << '\n';
    // clearing cin.fail() status
    cin.clear();
    // clearing the iostream buffer
    cin.ignore(256,'\n');
      // ask for input and save it in time
    std::cin >> time;

  }

  // returning time as a return for the function validate_time()
  return time;

}

// function that will run validate_time and check wether the return is in proper time format
float ask_time(){

  // declaring a float named time to store time from validate_time()
  float time ;
  // declaring a integer names minuts to store time frome extract_min()
  int minuts;

  do {

    // running the function validate_time() and saving its return in time
    time = validate_time() ;
    //running the function extract_min and saving its return in minuts
    minuts= extract_min(time);

    // if statment to check wether hours are > 23
    if (time>=24) {
      std::cout << "hours cant be > 23" << '\n';
    }

    // if statment checking wether minuts are > 59
    if(minuts>59) {
      std::cout << "minuts cant be > 59" << '\n';
    }

    // loop that will run until the hours and minuts are not smaller than 24 and 60 respectivly
  } while(time>=24 || minuts>59  );

  // returning time for the return for the function ask_time()
  return time ;
}



int main () {

  // declaring variable to store the time entered and time exit
	float time_entered, time_exit,time ;
  // declaring variable to store hours
  float hours;

  std::cout << "Enter the time entered like 24:09" << '\n';
  // running the function ask_time() and storing it in time_entered
  time_entered= ask_time();

  std::cout << "Enter the time exit like 45.34" << '\n';
  // running the function ask_time() and storing it in time_exit
  time_exit= ask_time();

  // calculating the time spend by subtracting time entered from time exit
  time = time_exit- time_entered;
  // adjusting the hours if the hours come in negative as if the user leaves
  // the next day by adding 24 hours in it
  hours= time_exit<time_entered ? time+24 : time;

  // incrementing the hour count if the minuts difference is more than 59 minuts
  if(extract_min(time)>59){
    hours++;
  }
  
  std::cout << "The time difference is " << hours << '\n';
	
  return 0;

}
