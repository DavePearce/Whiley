import * from whiley.lang.*

type OpenRecord1 is {int field, ...}

type OpenRecord2 is {int field}

function getField(OpenRecord1 r) => OpenRecord2:
    return r
