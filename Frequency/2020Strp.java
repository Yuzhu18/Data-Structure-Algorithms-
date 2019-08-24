import java.util.HashMap;
import java.util.Map;

public class Main {

    public static int getAmount(String[] input) {
        final int CREATE = 0;
        final int FINALIZE = 1;
        final int PAY = 2;

        if (input.length == 0) {
            return 0;
        }
        Map<Integer, Invoice> map = new HashMap<Integer, Invoice>();
        for (int i = 0; i < input.length; i++) {
            String[] cur = input[i].split(" ");
            // get id first
            int id = getId(cur[1]);
            int action = getAction(cur[0]);
            if (!map.containsKey(id)) {
                // first action must be "CREATE"
                if (action == CREATE) {
                    Invoice item = getInvoice(cur[1], CREATE);
                    map.put(id, item);
                }
            } else {
                Invoice current = map.get(id);
                //check action, status
                if (action == FINALIZE && current.status == CREATE) {
                    Invoice element = getInvoice(cur[1], 1);
                    map.put(id, element);
                } else if (action == PAY && current.status == FINALIZE) {
                    Invoice element = getInvoice(cur[1], PAY);
                    map.put(id, element);
                }
            }
        }

        int result = 0;
        //loop hashMap and check currency
        for (Map.Entry<Integer, Invoice> entry: map.entrySet()) {
            //check if currency is USD and plus amount
            if (entry.getValue().currency.equals("USD")) {
                result += entry.getValue().amount;
            }
        }
        return result;
    }

    private static int getAction(String left) {
        String action = left.substring(0, left.length() - 1);
        if (action.equals("CREATE")) {
            return 0;
        } else if (action.equals("FINALIZE")) {
            return 1;
        } else {
            return 2;
        }
    }

    private static Invoice getInvoice(String right, int action) {
        String[] elements = right.split("&");
        int amount = 0;
        String currency = "";

        for (String e : elements) {
            String[] param = e.split("=");
            if (param[0].equals("amount")) {
                amount = Integer.parseInt(param[1]);
            } else if (param[0].equals("currency")) {
                currency = param[1];
            }
        }
        // check if it is payed
        if (action == 2) {
            amount = 0;
        }

        Invoice invoice = new Invoice(amount, currency, action);
        return invoice;
    }

    private static int getId(String right) {
        String[] elements = right.split("&");
        int id = -1;
        for (String e : elements) {
            String[] item = e.split("=");
            if (item[0].equals("id")) {
                id = Integer.parseInt(item[1]);
            }
        }
        return id;
    }

    static class Invoice {
        private int amount;
        private String currency;
        private int status;

        public Invoice(int amount, String currency, int status) {
            this.amount = amount;
            this.currency = currency;
            this.status = status;
        }
    }
}

