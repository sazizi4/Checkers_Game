describe("Automate API Steps", () => {
  it("should automate API steps", () => {
      // Step 1: Navigate to the site
      cy.visit("https://deckofcardsapi.com/");

      // Step 2: Confirm the site is up
      cy.get("body").should("be.visible");

      // Step 3: Get a new deck
      cy.request("GET", "https://deckofcardsapi.com/api/deck/new/")
          .its("body.deck_id")
          .as("deckId");

      // Step 4: Shuffle the deck
      cy.request("GET", `https://deckofcardsapi.com/api/deck/new/shuffle/`);

      // Step 5: Deal three cards to each player
      cy.request("GET", `https://deckofcardsapi.com/api/deck/new/draw/?count=6`)
          .its("body.cards")
          .then(cards => {
              const player1Cards = cards.slice(0, 3);
              const player2Cards = cards.slice(3, 6);
              cy.wrap(player1Cards).as("player1Cards");
              cy.wrap(player2Cards).as("player2Cards");
          });

      // Step 6: Check for blackjack
      cy.get("@player1Cards").then(player1Cards => {
          const player1HasBlackjack = checkForBlackjack(player1Cards);
          cy.get("@player2Cards").then(player2Cards => {
              const player2HasBlackjack = checkForBlackjack(player2Cards);

              if (player1HasBlackjack || player2HasBlackjack) {
                  cy.log("Blackjack detected:");
                  if (player1HasBlackjack) {
                      cy.log("Player 1 has blackjack!");
                  }
                  else if (player2HasBlackjack) {
                      cy.log("Player 2 has blackjack!");
                  }
              }
          });
      });
  });
});

function checkForBlackjack(cards) {
  const hasAce = cards.some(card => card.value === "ACE");
    const hasTenPointCard = cards.some(card => ["10", "JACK", "QUEEN", "KING"].includes(card.value.toUpperCase()));

    return [hasAce, hasTenPointCard];
  // Implement logic to check if the given cards have a blackjack
  // Return true or false based on the check
}
