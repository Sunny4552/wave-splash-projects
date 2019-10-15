//============================================================================
// Name        : Lab4.cpp
// Author      : Sunny Mistry
// Version     : The BEAST Version
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <fstream>
#include <cstdlib>
#include <ctype.h>
#include <iomanip>
#include <cstring>
#include <string>
using namespace std;
void Exercise1();
void Exercise2();
string Replace(string str);

int main()
{
	Exercise1();
  int choice = 1;

  while(choice == 1)
  {
	  Exercise2();
    cout << "Enter num[1] to enter another sentence" << endl;
    cout << "Else to exit" << endl;
    cin >> choice;
  }

}

void Exercise1() //will remove whitespaces till one and captilizes first letter
{
	char str[200];
	char final[100];
	char get[100];

  cout << "Exercise 1" << endl;
  cout << "--------------------------" << endl;
	cout << "Enter string with size less the 100: " << endl;
	while(str[strlen(str) - 1] != '.')
	{
	cin.getline(get, 100);
	strcat(str, " ");
	strcat(str, get);

	}

	//cout << str << endl;
	int x = strlen(str);
	//cout << x << endl;;

	int index = 0;
	int first = 0;

	for(int i = 7; i < x + 1; i++)
	{
		if(isspace(str[i]))
		{

			for(int k = 1; k < x + 1; k++)
			{

				if(!isspace(str[i + k]))
				{
					final[index] = ' ';
					i = i + k - 1;
					break;
				}

			}
		}
		else
		{
			if(!isspace(str[i]))
			{
				first++;
			}
			if(first == 1)
			{
				final[index] = toupper(str[i]);
			}
			else
				final[index] = tolower(str[i]);
		}
		//final[index] = tolower(str[i]);
		index++;

	}

	cout << final << endl;;

}


void Exercise2()
{
   cout << "Exercise 2" << endl;
  cout << "--------------------------" << endl;
  string word = "";
  cout << "Enter sentence: " << endl;
	getline(cin, word);

  string final = "";
  char next;


	//cout << word << endl;

  //Replacing orginal string with modified pronouns
	//int index = 0;
	for(int i = 0; i < word.length(); i++)
	{
     string test = "";
    while(true)
    {

      next = word[i];
      if(isalpha(next))
      {

        test = test + next;

      }
      else
      {
        break;
      }
      i++;

    }

    final = final + Replace(test);
    if(!isalpha(word[i]))
    {
      final = final + word[i];
    }
	}

	//cout << word << endl;
	cout << final << endl;
}

string Replace(string str)
{

  if(str == "him")
  {
    return "her or him";
  }
  else if(str == "his")
  {
    return "her(s) or his";
  }
  else if(str == "he")
  {
    return "she or he";
  }
  else
  return str;
}


