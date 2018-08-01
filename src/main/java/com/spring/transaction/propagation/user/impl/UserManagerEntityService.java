package com.spring.transaction.propagation.user.impl;

import java.util.List;

import com.spring.transaction.propagation.dao.impl.UserDAOImpl;
import com.spring.transaction.propagation.model.User;
import com.spring.transaction.propagation.user.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
//@Transactional
public class UserManagerEntityService implements UserManager {

    @Autowired
    private UserDAOImpl userDAO;

    public void insert() {

        /**
         * REQUIRED propagation'u aynı session içerisinde çalıştığı için yani blok bitene kadar aynı session çalıştığı için
         * hata durumunda bütün blok işlemleri geri alınır.
         */
//        insertUser_REQUIRED ();
//        insertUser_REQUIRED_EXP ();

        /**
         * REQUIRED : Aynı sessionn üzerinden çalışırlar. Yukarıdaki transactiona bağlıdır.
         */
//        insertUser_REQUIRED ();
//        insertUser_REQUIRED2();

        /**
         *  REQUIRES_NEW propagation'u aynı blok içerisinde olsa bile var olan session'ı askıya alır.
         *  Create a new transaction, and suspend the current transaction if one exists.
         *  Yeni bir session açar ve işlemi hatasız bitirdikten sonra aynı blok içerisinde başka bir propagaiton üzerinden
         *  hata olsa bile işlem geri alınmaz.
         */
//        insertUser_REQUIRES_NEW();
//        insertUser_REQUIRES_NEW_EXP();
//        insertUser_REQUIRES_NEW_BLOK();

        /**
         * REQUIRES_NEW her açtığı session'ı committen sonra kapattığı için REQUIRED hata aldığında sadece kendibloğunu commitlemez.
         * REQUIRES_NEW var olan transactionu askıya aldığı ve ayrı bir session üzerinden çalıştığı için en üstte req olarak açılsa bile commit yapar kapanır.
         * Altında çalışan hatalı metotlarla aynı blok içerisinde olsa bile etkilenmez.
         */
//        insertUser_REQUIRES_NEW();
//        insertUser_REQUIRED_EXP ();

        /**
         * required session açar, genel metottan çıkana kadar bu session kapanmaz.
         * Transaciton başlatıldığı ve required olduğu için alttaki metot patladığı anda bütün metodun içini geri alır.

         */
//        insertUser_REQUIRED();
//        insertUser_REQUIRES_NEW_EXP();

        /**
         * MANDATORY :Support a current transaction
         * Kendinden önce bir transaction başlamışsa(Türü ne olursa olsun) REQUIRED gibi davranır.
         * Zorunlu anlamına gelen mandatory ile kendinden önce bir transaction başlatılmamışsa eğer hata alacaktır.
         */
//        insertUser_MANDATORY();
//        insertUser_REQUIRES_NEW();
//        insertUser_REQUIRES_NEW_EXP();

        /**
         * NEVER :Existing transaction found for transaction marked with propagation 'never'
         * Eğer kendinden önce bir transaction başlatılmışssa hata fırlatacaktır.
         */
//        insertUser_NEVER();

        /**
         * Nested Propagation tag’i sadece DataSourceTransactionManager transaction manager ile çalışmaktadır.
         * Çünkü her bir transaction’ın açılan bağlantı özelinde kontrol edilmesi gerekir.
         Eğer başlamış bir transaction yoksa yenii bir transaction başlatır.
         Eğer öncesinden bir transaction başlatılmışsa var olandan devam eder. Ancak bir “savepoint” işaretler metoda girerken.
         Yani bir metot içerisndeki hata durumunda savepoint’e kadar işlemi geri alır. Ondan sonrası devam eder.
         */
//        insertUser_NESTED();

        /**
         * SUPPORTS :kendinden önce bir transaction oluşmuşsa ona dahil olur ve onun içnde çalışır.
         * Eğer kendinden önce yaratılmış bir transaction yok ise hata vermeden yine çalışır ancak transactional bir davranış sergilemez.
         * Kendinden sonraki transactionun önemi olmaz bu durumda.
         * Eğer kendinden önce transaction başlamışsa onun gibi hareket eder. Required ile başlamışsa onun gibi hepsi geri alınır.
         */
//        insert_SUPPORTS ();

        /**
         * NOT_SUPPORTED :Öncesinde bir transaction başlatılmasına gerek yoktur. Eğer bir transaction varsa onu askıya alır.
         * Metod bitiminde beklettiği transaction’ı devreye alır.
         * Öncesinde bir transaction varsa bile bağlanmaz. Direk non-transaction olarak çalışacaktır.
         */
//        insert_NOT_SUPPORTED ();


        /**
         * Aşağıdaki örnekte sarmallanan hataların sonucunu görüyoruz. Transaction yapısı sarmallanan hatalar için geçerli olmayabilir.
         * Yani required gibi bir hatada üstünde çalışan bütün çalışan sistemi bile rollback eden yapı eğer hata sarmallanırsa çalışmayabilir.
         *
         */
//        insertUser_REQUIRED_DIFF_ROLLBACKS ();


    }

    private void insertUser_REQUIRES_NEW_BLOK() {
        User user = null;
        for (int i = 0; i < 5; i++) {
            if (i != 3) {
                user = new User ();
            }else{
                user = null;
            }
            user.setName ("sinan" + i);
            userDAO.insertUser_REQUIRES_NEW_BLOK (user);
        }

    }

    private void insertUser_REQUIRED_DIFF_ROLLBACK() throws Exception {
        try {
            User user = null;
            user.setName ("burçak");
            userDAO.insertUser_REQUIRED (user);

        }catch (Exception e){
          throw new Exception ();
        }
    }

    private void insertUser_REQUIRED_DIFF_ROLLBACKS(){
            userDAO.insertUser_DIFF_ROLLBACK ();

    }

    private void insert_NOT_SUPPORTED() {
        User user = null;
        for (int i = 0; i < 5; i++) {
            if (i != 3) {
                user = new User ();
            }else{
                user = null;
            }
            user.setName ("mehmet" + i);
            userDAO.insert_NOT_SUPPORTED (user);
        }
    }

    private void insert_SUPPORTS() {
        User user = null;
        for (int i = 0; i < 5; i++) {
            if (i != 3) {
                user = new User ();
            }else{
                user = null;
            }
            user.setName ("seyma" + i);
            userDAO.insert_SUPPORT (user);
        }
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
    private void insertUser_NESTED() {
        User user = new User ();
        user.setName ("samet");
        userDAO.insertUser_NESTED (user);

    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NEVER)
    private void insertUser_NEVER() {
        User user = new User ();
        user.setName ("samet");
        userDAO.insertUser_NEVER (user);

    }

    private void insertUser_MANDATORY() {
        User user = new User ();
        user.setName ("nurcan");
        userDAO.insertUser_MANDATORY (user);

    }

    private void insertUser_REQUIRES_NEW() {
        User user = new User ();
        user.setName ("sevgi");
        userDAO.insertUser_REQUIRES_NEW (user);

    }

    private void insertUser_REQUIRES_NEW_EXP() {
        User user = null;
        user.setName ("burkoo");
    }

    public void insertUser_REQUIRED() {

        User user = new User ();
        user.setName ("burak");
        userDAO.insertUser_REQUIRED (user);

    }

    private void insertUser_REQUIRED2() {
        User user = new User ();
        user.setName ("canan");
        userDAO.insertUser_REQUIRED (user);

    }

    private void insertUser_REQUIRED_EXP() {
        User user = null;
        user.setName ("burçak");

    }

    @Transactional
    public User getUserById(int userId) {
        return userDAO.getUserById (userId);
    }

    @Transactional
    public User getUser(String username) {
        return userDAO.getUser (username);
    }

    @Transactional
    public List<User> getUsers() {
        return userDAO.getUsers ();
    }

}
