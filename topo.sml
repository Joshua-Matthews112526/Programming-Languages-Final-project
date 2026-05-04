fun dfs (g, v, visited, stack, result) =
  if List.exists (fn x => x = v) stack then
    ("cycle", v :: stack , visited)
  else if List.exists (fn x => x = v) visited then
    ("ok", result, visited)
  else
    let
      val newStack = v :: stack
      val nbrs = neighbors g v

      fun visitAll [] (res, vis) = ("ok", res, vis)
        | visitAll (n::ns) (res, vis) =
            case dfs (g, n, vis, newStack, res) of
                ("cycle", c, vis2) => ("cycle", c, vis2)
              | ("ok", r2, vis2) => visitAll ns (r2, vis2)
    in
      case visitAll nbrs (result, visited) of
          ("cycle", c, vis2) => ("cycle", c, vis2)
        | ("ok", r2, vis2) =>
            ("ok", v :: r2, v :: vis2)
    end


fun topo g =
  let
    fun process [] visited result =
          ("ok", result)
      | process ((v, _)::vs) visited result =
          if List.exists (fn x => x = v) visited then
            process vs visited result
          else
            case dfs (g, v, visited, [], result) of
                ("cycle", c, _) => ("cycle", c)
              | ("ok", r, vis2) => process vs vis2 r
  in
    process g [] []
  end