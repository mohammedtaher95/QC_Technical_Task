# Trello Mobile Application Test Plan

## High-Level Scenarios:

### Confirming Requirements:

1. Verify that the user can create a new board
    1. Open the Trello mobile application
    2. Tap on the "Create new board" button
    3. Select a board template from board templates 
    4. Click on "Create board with template"
    5. Enter a valid name for the board
    6. Tap on the "Create" button
    7. Confirm that a new board has been successfully created and is visible on the home screen.

2. Verify that the user can add a list to the board
    1. Open an existing board
    2. Tap on the "Add a list" button
    3. Enter a valid name for the list
    4. Tap on the tick button on the top right of screen
    5. Confirm that a new list has been successfully added to the board.

3. Verify that the user can add a card to the list
    1. Tap on the "Add a card" button on an existing list
    2. Enter a valid title for the card
    3. Tap on the tick button on the top right of screen
    4. Confirm that a new card has been successfully added to the list.

4. Verify that the user can move a card from one list to another
    1. Open an existing card
    2. Tap on Menu icon on the top right of screen
    3. Tap on the "Move Card" button
    4. Select the destination list from the available lists
    5. Tap on the tick button on the top right of screen
    6. Confirm that the card has been moved to the selected list.

5. Verify that the user can edit a card's details
    1. Open an existing card
    2. Tap on Any editable field, ex: description, card name
    3. Make changes to the card's details
    4. Tap on the tick button on the top right of screen
    5. Confirm that the card's details have been successfully updated.

6. Verify that the user can delete a card
    1. Open an existing card
    2. Tap on Menu icon on the top right of screen
    3. Tap on the "Delete" button
    3. Confirm the deletion of the card
    4. Confirm that the card has been successfully deleted from the list.

7. Verify that the user can archive a list
    1. Tap on Menu icon on an existing list
    2. Tap on the "Archive" button
    3. Confirm that the list has been successfully archived and removed from the board.

### Negative Scenarios:

1. Verify that the user cannot create a board without a name
    1. Open the Trello mobile application
    2. Tap on the "Create new board" button
    3. Leave the name field blank
    4. Confirm that "Create board" button should be disabled.

2. Verify that the user cannot add a list without a name
    1. Open an existing board
    2. Tap on the "Add list" button
    3. Leave the name field blank
    4. Tap on the tick button on the top right of screen
    5. Confirm that list shouldn't be created.

3. Verify that the user cannot add a card without a title
    1. Open an existing list
    2. Tap on the "Add card" button
    3. Leave the title field blank
    4. Tap on the tick button on the top right of screen
    5. Confirm that tick button on the top right of screen should be disabled.

4. Verify that the user cannot move a card to a non-existent list
    1. Open an existing card
    2. Tap on the "Move" button
    3. Select a non-existent list from the available lists
    4. Confirm that an error message is displayed indicating that the selected list does not exist.

5. Verify that the user cannot edit a card's details without making any changes
    1. Open an existing card
    2. Tap on the "Edit" button
    3. Do not make any changes to the card's details
    4. Tap on the "Save" button
    5. Confirm that an error message is displayed indicating that changes are required to update the card.


## Prioritization of Test Cases:
- Verify that the user can create a new board **(High)**
- Verify that the user can add a list to the board **(High)**
- Verify that the user can add a card to the list **(High)**
- Verify that the user can move a card from one list to another **(High)**
- Verify that the user can edit a card's details **(High)**
- Verify that the user can delete a card **(High)**
- Verify that the user can archive a list **(High)**
- Verify that the user cannot create a board without a name **(High)**
- Verify that the user cannot add a list without a name **(High)**
- Verify that the user cannot add a card without a title **(High)**
- Verify that the user cannot move a card to a non-existent list **(Medium)**
- Verify that the user cannot edit a card's details without making any changes **(Medium)**

