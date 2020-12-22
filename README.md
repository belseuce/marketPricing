# marketPricing
supermarket kata

Te goal is go give my version of Supermarket pricing modeling.

assumptions:
- all pricing strategies can occur simultaneously
- selling by weight is implemented by ounce. Ca be extends to manage livre and ounce both in user input
- article promotion pack are indivisible. so additional articles fall back in other price strategy

Problem:

The problem domain is something seemingly simple: pricing goods at
supermarkets.
 
Some things in supermarkets have simple prices: this can of beans
costs $0.65. Other things have more complex prices. For example:
•     three for a dollar (so what’s the price if I buy 4, or 5?)
•     $1.99/pound (so what does 4 ounces cost?)
•     buy two, get one free (so does the third item have a price?)
 
The exercise is to experiment with a model that is flexible enough
to deal with these (and other) pricing schemes, and at the same time
are generally usable how do you keep an audit trail of pricing
decisions.
