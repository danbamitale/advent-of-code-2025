Password Lock – Zero Transition Logic

This project implements a circular password lock with a special rule for counting zero transitions. The behavior is driven entirely by the problem specification and validated by the accompanying test suite.

⸻

Overview

The lock consists of a circular dial with a fixed size (LOCK_LIMIT, e.g. 100) and a current state in the range:

0 ≤ state < LOCK_LIMIT

The dial can be rotated:
•	Right (R) by a positive number of steps
•	Left (L) by a positive number of steps (interpreted as negative movement)

In addition to tracking the current state, the lock can optionally track zero transitions.

⸻

What Is a Zero Transition?

A zero transition is counted according to the following rule:

The zero counter increments every time the dial reaches zero during a move, excluding the starting position.

This includes:
•	Crossing zero from either direction
•	Landing exactly on zero
•	Completing a full cycle back to zero (one count per full cycle)

And excludes:
•	The starting position if the move begins at zero
•	Partial movements that never reach zero

The rule applies regardless of direction.

⸻

Intuitive Mental Model

Imagine physically rotating a dial with your finger:
•	Every time your finger touches the zero mark, increment the counter
•	Do not count the finger already resting on zero before the move
•	If you spin multiple times, you touch zero once per spin

This model exactly matches the implementation and the test expectations.

⸻

Examples

Assume:
•	LOCK_LIMIT = 100
•	INITIAL_LOCK_STATE = 0

Movement	Explanation	Zero Count
R50	Leaves zero and wraps past it once	1
L50	Leaves zero and wraps past it once	1
R1000	10 full cycles	10
L1000	10 full cycles	10
L50; L1000	1 partial + 10 full	11
R50; R1000	1 partial + 10 full	11


⸻

Why This Is Not Simple Modulo Arithmetic

Standard modular arithmetic (floorMod, %) only describes the final position.

This problem depends on the path taken during a move:
•	Full rotations matter
•	Partial crossings matter
•	Direction does not matter

Because of this, zero transitions cannot be derived from the final state alone.

⸻

Implementation Notes
•	The lock always updates its state using a safe floorMod-style operation
•	Zero transitions are counted based on the raw movement (prevState → transition)
•	Special care is taken to avoid counting the starting zero

The implementation is intentionally explicit to match the domain rules rather than relying on overly compact math tricks.

⸻

Tests as the Source of Truth

All behavior described above is enforced by the test suite.

If a rule is unclear, the tests define the contract.

Any refactor or optimization must preserve:
•	Correct zero counting
•	Correct handling of partial moves
•	Correct handling of multiple full rotations

⸻

Summary
•	The dial is circular
•	Zero transitions are path-based, not state-based
•	Every meaningful reach of zero counts
•	Starting at zero does not count
