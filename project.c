#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// User details for sign-up
struct userDetails {
    int age;
    char userName[100];
    char email[100];
    char mobile[20];
    char password[20];
};

// Hotel details & their food details
struct hotelDetails {
    char hotel_name[100];
    char first_food[50];
    char second_food[50];
    char third_food[50];
    int first, second, third;
};

// Initialize the hotels & user details
struct hotelDetails hotel[6];
struct userDetails user[100];

// Declarations of functions
void signup();
void account_check();
int is_valid();
void login();
void cart();
void search_by_hotels();
void search_by_food();
void food_order(int food);
void hotel_initialize();
void hotels(int hotel_choice);

// Global variables (minimized)
int j = 0;
char temp_name[100], temp_password1[20], temp_password2[20], temp_email[100], temp_mobile[20];
int temp_age, total = 0;

// Food Ordering system
int main() {
    int choice;
    while (1) {
        printf("\n\n\t\tWelcome to our Food Ordering System\n");
        printf("\n1. Sign-up\n2. Login\n3. Exit\n");
        printf("Please enter your choice: ");
        scanf("%d", &choice);

        switch (choice) {
            case 1:
                signup();
                break;
            case 2:
                login();
                break;
            case 3:
                exit(0);
            default:
                printf("\nPlease enter a valid choice\n");
                break;
        }
    }
    return 0;
}

// function signup
void signup() {
    printf("\n\n***********SIGNUP************\n\n");

    // flushes the standard input (clears the input buffer)
    while ((getchar()) != '\n');

    printf("Enter Your Name: ");
    scanf("%[^\n]%*c", temp_name);

    printf("Enter Your Age: ");
    scanf("%d", &temp_age);

    printf("Enter Your Email: ");
    scanf("%s", temp_email);

    printf("Enter Password: ");
    scanf("%s", temp_password1);

    printf("Confirm Password: ");
    scanf("%s", temp_password2);

    printf("Enter Your Mobile Number: ");
    scanf("%s", temp_mobile);

    // Validate inputs
    int validate = is_valid();
    if (validate == 1) {
        account_check();
    }
}

// Function to check if the account already exists or not
void account_check() {
    for (int i = 0; i < j; i++) {
        if (strcmp(temp_email, user[i].email) == 0) {
            printf("\n\nAccount Already Exists. Please Login!\n");
            return;
        }
    }

    // Account does not exist, create a new one
    strcpy(user[j].userName, temp_name);
    strcpy(user[j].password, temp_password1);
    strcpy(user[j].email, temp_email);
    strcpy(user[j].mobile, temp_mobile);
    user[j].age = temp_age;
    j++;

    printf("\n\nAccount Successfully Created!\n\n");
}

// function to validate the user account for signing-up
int is_valid() {
    // Validating the name
    for (int i = 0; temp_name[i] != '\0'; i++) {
        if (!((temp_name[i] >= 'a' && temp_name[i] <= 'z') || (temp_name[i] >= 'A' && temp_name[i] <= 'Z') || temp_name[i] == ' ')) {
            printf("\nPlease enter a valid name\n");
            return 0;
        }
    }

    // Validating email
    int At = -1, Dot = -1;
    if (!((temp_email[0] >= 'a' && temp_email[0] <= 'z') || (temp_email[0] >= 'A' && temp_email[0] <= 'Z'))) {
        printf("\nPlease enter a valid email address.\n");
        return 0;
    }
    for (int i = 0; temp_email[i] != '\0'; i++) {
        if (temp_email[i] == '@') At = i;
        if (temp_email[i] == '.') Dot = i;
    }
    if (At == -1 || Dot == -1 || At > Dot || Dot >= (strlen(temp_email) - 1)) {
        printf("\nPlease enter a valid email address.\n");
        return 0;
    }

    // Validating password
    if (strcmp(temp_password1, temp_password2) != 0 || strlen(temp_password1) < 8 || strlen(temp_password1) > 12) {
        printf("\nPasswords do not match or do not meet length criteria.\n");
        return 0;
    }

    // Validate mobile number
    if (strlen(temp_mobile) != 10 || temp_mobile[0] == '0') {
        printf("\nPlease enter a valid mobile number.\n");
        return 0;
    }
    for (int i = 0; i < 10; i++) {
        if (temp_mobile[i] < '0' || temp_mobile[i] > '9') {
            printf("\nPlease enter a valid mobile number.\n");
            return 0;
        }
    }

    // Validating the user age
    if (temp_age <= 0) {
        printf("\nPlease enter a valid age.\n");
        return 0;
    }

    return 1;
}

// login function
void login() {
    char login_email[100], login_password[20];
    printf("\n\n****************LOGIN*****************\n\n");
    printf("\nEnter Your Email: ");
    scanf("%s", login_email);

    printf("Enter Your Password: ");
    scanf("%s", login_password);

    for (int i = 0; i < j; i++) {
        if (strcmp(user[i].email, login_email) == 0) {
            if (strcmp(user[i].password, login_password) == 0) {
                printf("\n\nWelcome! You have successfully logged in :)\n\n");
                // Call a menu or function here based on login success
                return;
            } else {
                printf("\nInvalid password! Please enter the correct password.\n");
                return;
            }
        }
    }
    printf("\nThis account doesn't exist. Please sign up to create your account!\n");
}

// Function that initializes the hotels
void hotel_initialize() {
    strcpy(hotel[1].hotel_name, "Freshers Delight");
    strcpy(hotel[1].first_food, "Veg momo");
    strcpy(hotel[1].second_food, "Pizza");
    strcpy(hotel[1].third_food, "Tandoori Sauce Potato");
    hotel[1].first = 730;
    hotel[1].second = 100;
    hotel[1].third = 195;

    strcpy(hotel[2].hotel_name, "Barbeque Nation");
    strcpy(hotel[2].first_food, "Non veg momos");
    strcpy(hotel[2].second_food, "Noodles");
    strcpy(hotel[2].third_food, "Chicken crispy finger");
    hotel[2].first = 80;
    hotel[2].second = 85;
    hotel[2].third = 380;

    // Add more hotel details...
}
