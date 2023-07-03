package camp.db;

import camp.model.Object;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ObjectRepository implements IObjectRepository {
    Random random = new Random();
    private List<Object> objectList = new ArrayList<>();
    @Override
    public void ObjectRepository() {
        objectList.add(new Object(random.nextDouble(), "ebec43e76eef0a8699b4f4f5ce4cc5b3"));
        objectList.add(new Object(random.nextDouble()));
        objectList.add(new Object(random.nextDouble()));
        objectList.add(new Object(random.nextDouble()));
        objectList.add(new Object(random.nextDouble()));
    }

    @Override
    public void drawHashCheck() {

        for (int i = 0; i < objectList.size(); i++) {
            boolean run = true;
            while (run) {
                objectList.get(i).setNonce(random.nextLong());
                String hash = DigestUtils.md5Hex(objectList.get(i).toString());
                run = !(hash.substring(hash.length() - 5, hash.length()).equals("00000"));
                if (i != objectList.size() - 1) {
                    objectList.get(i + 1).setLastTransaction(hash);
                }
            }
        }

        for (int i = 0; i < objectList.size(); i++) {
            System.out.println(objectList.get(i).getAmount() + " " + objectList.get(i).getLastTransaction() + " " + objectList.get(i).getNonce());
            System.out.println(DigestUtils.md5Hex(objectList.get(i).toString()));
        }
    }
}
