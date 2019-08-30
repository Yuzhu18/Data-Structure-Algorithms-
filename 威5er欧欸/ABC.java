public static String solution (int A, int B, int C) {
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Letter> maxHeap = new PriorityQueue<Letter>(new Comparator<Letter>() {
            @Override
            public int compare(Letter o1, Letter o2) {
                return o2.num - o1.num;
            }
        });

        if (A > 0) {
            Letter letterA = new Letter(A, "a");
            maxHeap.offer(letterA);
        }
        if (B > 0) {
            Letter letterB = new Letter(B, "b");
            maxHeap.offer(letterB);
        }
        if (C > 0) {
            Letter letterC = new Letter(C, "c");
            maxHeap.offer(letterC);
        }

        Letter prev = null;
        while (!maxHeap.isEmpty()) {
            Letter current = maxHeap.poll();

            if ( prev == null || prev.value != current.value ) {
                prev = current;
                sb.append(current.value);
                current.num = current.num - 1;
                if (current.num > 0) {
                    sb.append(current.value);
                    current.num = current.num - 1;
                }
            } else if (prev.value == current.value) {
                if (maxHeap.isEmpty()) {
                    break;
                }
                Letter next = maxHeap.poll();
                prev = next;

                sb.append(next.value);
                next.num = next.num - 1;
                if (next.num > 0) {
                    sb.append(next.value);
                    next.num = next.num - 1;
                }

                if (next.num != 0) {
                    maxHeap.offer(next);
                }
            }

            if (current.num != 0) {
                maxHeap.offer(current);
            }
        }
        return sb.toString();
    }

    static class Letter {
        private String value;
        private int num;
        private Letter(int num, String value) {
            this.num = num;
            this.value = value;
        }
    }
