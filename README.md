# WPIHackathon2022

https://github.com/cehrensperger/WPIHackathon2022/assets/19954402/ff4d596d-3304-44dd-b898-beefaf908587

Participating in a Hackthon was a first for both my teammate and I. We did not have much knowlegde or experience going in to it, but we were excited to learn. I recently started learning about Perlin noise at the time and its many organic looking uses intrigued me. I then proposed the idea of using Perlin noise as part of a simple 2D game. 

### The Game Idea
The idea was to use Perlin noise to generate certain areas of the screen that the user should try to avoid by moving the mouse off of those "dangerous" (colorful) areas and onto the "safe" (gray) areas.

### Implementation
We achieved this by generating noise values using a typical implementation of the Perlin noise algorithm for each pixel of the screen. If that noise value was above a certain threshold, it would be considered dangerous. These dangerous pixels would then be colored randomly, with their RGB values also being generated using the Perlin noise algorithm. 

### Gamification
To make the game more exciting, my teammate and I decided to increase the speed of the game as time goes on and have the player's health slowly decrease if the mouse is in a colorful area for too long. The player then tries to stay alive for as long as possible using the amount of time survived as their score. 

### Technologies Used
This project was made in Java and JavaFX. 
