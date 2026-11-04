# RUET Debating Club Management App

An Android application developed to make the management of the **RUET Debating Club** more convenient. The app helps club members stay informed about notices and activities, simplifies the member-registration process, and allows administrators to publish updates from a shared platform.

## Overview

The application provides separate interfaces for regular members and administrators. Members can create an account, submit their club-registration details, and read notices published by the administrator. Administrators can log in through a dedicated interface and upload notices for members to view.

An important part of the design is that an administrator is also a club member. Therefore, an administrator must first register as a regular user before accessing the admin features.

## Technologies Used

- **IDE:** Android Studio
- **Programming language:** Java
- **User interface:** XML
- **Authentication:** Firebase Authentication
- **Member data:** Firebase Realtime Database
- **Notice storage:** Firebase Storage

## Main Features

### Member Features

- Sign up using an email address and password.
- Log in using registered credentials.
- Submit a club-registration form after signing in.
- View notices and activity updates published by the administrator.
- Navigate between the home feed and the club information section.
- Log out of the application.

### Administrator Features

- Access a dedicated admin login interface.
- Log in only after registering as a regular user and satisfying the predefined administrator-credential check.
- Write and upload notices or activity updates.
- View the same notice feed available to regular members.
- Navigate through the application and log out.

## Application Workflow

1. A new member creates an account using the **Sign Up** screen.
2. Firebase Authentication creates the account and assigns it a unique user ID (UID).
3. The member completes the registration form. The app uses the UID to associate the member's information with their account in Firebase Realtime Database.
4. After registration, the member is taken to the home feed, where published notices are displayed.
5. An administrator first signs up as a regular member, then uses the separate **Admin Log In** screen.
6. After successful admin authentication, the administrator can publish notices. Members and administrators can view the published updates in the feed.

## App Screens and Components

| Layout file | Purpose |
|---|---|
| `activity_main.xml` | Sign-up screen for creating a user account with email and password. It also provides navigation to the login screen. |
| `activity_register.xml` | Member-registration form. The submitted information is associated with the authenticated user's UID. |
| `activity_main2.xml` | Regular member login screen, with navigation to sign up and to the admin login screen. |
| `activity_admin_log_in.xml` | Dedicated administrator login screen. The administrator must already have a registered user account and satisfy the predefined admin-credential check. |
| `activity_admin_feed.xml` | Administrator interface for writing and uploading notices or activity updates. |
| `activity_friend.xml` | Member-facing notice feed. Administrators can also view this feed as members. |
| `nav_drawer.xml` | Navigation drawer shared by the member and administrator interfaces. It provides Home, About Club, and Log Out options. |
| `activity_splash.xml` | Splash screen displayed while the application launches. |

The XML files define the user interfaces, while the corresponding Java classes implement their functionality and connect the app to Firebase services.

## Firebase Integration

### Firebase Authentication

The sign-up screen uses Firebase Authentication to create accounts with email and password. The `createUserWithEmailAndPassword()` method creates the account. When successful, Firebase provides a unique user ID (UID), which is then used to associate the user's registration information with their account.

### Firebase Realtime Database

The registration functionality obtains a database reference using the authenticated user's UID. A Java helper class named `User_helper` collects the registration-form values and prepares the user data for storage. User records are organised under a `Users` node, with each member's nickname used as the corresponding child node.

### Firebase Storage

The administrator notice-upload interface allows an administrator to submit a notice. The project uses Firebase Storage for storing uploaded notice content, which is then made available in the member-facing feed.

## Navigation

The navigation drawer is available from both the administrator feed and the member notice feed:

- **Home:** Opens the relevant feed.
- **About Club:** Opens a screen containing information about the club.
- **Log Out:** Signs the current user out and returns to the sign-up screen.

## Future Improvements

The following features are planned for future versions:

1. **Member messaging:** Enable communication between club members through the app.
2. **Admin member overview:** Provide administrators with an overview of registered member details.
3. **Individual profiles:** Add profile screens where members can view and manage their personal information.

## Project Objective

The project aims to reduce the complexity of club registration, keep member information organised, and make club notices and activity updates easier to access. By providing a shared platform for administrators and members, it can also serve as a foundation for managing communication and announcements in other university clubs or student groups.
