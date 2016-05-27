# PathfinderProgram
My home-brew program for a Pathfinder character sheet, as requested.

So far I'm just working on the character sheet aspect of it, but I've also heard some interest in NPC generation or 
things like encounter generators.


Current issue: Organization and optomization of spell data saving and lookup. 
Possible solution: Make a spell enum with all of the core spells (Not all of them due to the size of that file being too large to compile.), and put the rest as optional files to be downloaded. This way there's fastere general lookup, but with suport for other sources of spells.

Next Issues: Fixing skill point system (Needs data on trained/untrained, more obvious and efficient storage method for modifiers)
Importing Feats - similar to spells, so the work on the spell system should transfer over fairly well.


GUI Thoughts:
Finish up the basic layout currently made, obviously.
On the spell choosing system, if you double click on a spell it should (And can) pull up the spell's full details.
Feat choosing should be about the same.
Look at doing a tabbed system for the inventory/feats&abilities/spells/basic info
Look at doing a windowed system - I've read (incredibly briefly) about a windowpane(?) that can be pulled out of the current window and made separate. This could be helpful if the GM-Player system is set up, as the GM might have multiple player's sheets up.
