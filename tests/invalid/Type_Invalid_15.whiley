type Random is {nat index, nat[] sequence}
// index is valid position in random sequence
where index < |sequence|
// Sequence is valid card index
where all { i in 0..|sequence| | sequence[i] < 52 }

function next(Random r) -> (nat index, Random nr)
ensures index < 52:
    // Get item from random sequence
    int result = r.sequence[r.index]
    // Move to next item
    r.index = r.index + 1
    // Check for overflow
    if r.index == |r.sequence|:
        r.index = 0
    //
    return result, r
