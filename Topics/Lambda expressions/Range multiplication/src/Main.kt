val lambda: (Long, Long) -> Long =
    { left, right -> (left..right).fold(1) { total, item -> total * item } }