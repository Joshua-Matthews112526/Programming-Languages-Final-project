type vertex = string
type graph = (vertex * vertex list) list

fun neighbors g v =
  case List.find (fn (x, _) => x = v) g of
      SOME (_, nbrs) => nbrs
    | NONE => []