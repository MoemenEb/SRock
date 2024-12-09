# SRock
An interview repo
-- Drive Link: https://drive.google.com/drive/folders/1UBzT3W59jot5VAGwemBZ-z1ct8AO2EaJ?usp=sharing

>> This assessment aims to evaluate your skills and expertise as a Senior QA Engineer in designing, writing, and automating UI tests. You are required to demonstrate a thorough understanding of test automation by selecting an automation tool and a target application of your choice.

### High Level Scenarios
1. Signup
2. Login
3. Search for item
4. Add item to cart 
5. Complete purchase
6. Navigation
7. Contact company

- Most critical scenarios would be, purchase cycle, which includes: 
1. Add item to cart
2. Complete purchase 

- Search for item is critical, however for this website there is no search cabibilites just selecting between categories. Therefore search feature is not of hight critical value, nevertheless listing correct items is critical in that case. 
 
- Signup and Login, are considered a pre-requisete scenarios in normal use cases and the main tested scenarios. For this demo website guest account -non-logged in used- can select and purchase items.

- Navigation is crucial to make sure all pages are reachable.


# Login (Valid) 
Given user at home page

When login with correct credentials 

Then Login success 

And navigation bar display username

# Login (Invalid) 
Given user at home page

When login with in-correct credentials 

Then Login fail 

And alert appears

# Add item to cart
Given user at home page  //  Given Logged in user

When open product “Phones” - “Nexus 6”

When click on “Add to cart”

Then alert appears “product added”

When go to “cart” page

Then product “Nexus 6” Exists.

# Complete purchase order
Given user at home page  //  Given Logged in user

When add item “Phones” - “Nexus 6” to cart

When go to “cart” page

Then product “Nexus 6” Exists.

When click on “Place order”

Then place order modal appears

When fill order modal with valid and complete data (mon, Egy, Alex, 123, 12, 2024)

When click on “Purchase”

Then Thank you pop up appears with purchase data
