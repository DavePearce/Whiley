

type anat is (int x) where x >= 0

type bnat is (int x) where (2 * x) >= x

function atob(anat x) -> bnat:
    return (bnat) x

function btoa(bnat x) -> anat:
    return (anat) x

public export method test() :
    assume atob(1) == 1
    assume btoa(1) == 1
