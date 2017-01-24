package lbmf.project.com.contacts_map;

import android.content.ContentProviderOperation;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import android.provider.ContactsContract;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    List<String> idlist = new ArrayList<String>();
    List<Integer> rowid = new ArrayList<Integer>();
    List<String> rowname = new ArrayList<String>();
    List<String> rowusername = new ArrayList<String>();
    List<String> rowemail = new ArrayList<String>();
    List<String> rowstreet = new ArrayList<String>();
    List<String> rowsuite = new ArrayList<String>();
    List<String> rowcity = new ArrayList<String>();
    List<String> rowzipcode = new ArrayList<String>();

    List<String> rowphone = new ArrayList<String>();
    List<String> rowwebsite = new ArrayList<String>();
    List<String> rowCompany_name = new ArrayList<String>();
    List<String> rowcatchPhrase = new ArrayList<String>();
    List<String> rowbs = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("All Contacts"));
        tabLayout.addTab(tabLayout.newTab().setText("Contacts Map"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        viewPager = (ViewPager) findViewById(R.id.pager);
        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        tabLayout.setOnTabSelectedListener(this);

        try {


            JSONArray jr = new JSONArray("[\n" +
                    "  {\n" +
                    "    \"id\": 1,\n" +
                    "    \"name\": \"Leanne Graham\",\n" +
                    "    \"username\": \"Bret\",\n" +
                    "    \"email\": \"Sincere@april.biz\",\n" +
                    "    \"address\": {\n" +
                    "      \"street\": \"Kulas Light\",\n" +
                    "      \"suite\": \"Apt. 556\",\n" +
                    "      \"city\": \"Gwenborough\",\n" +
                    "      \"zipcode\": \"92998-3874\",\n" +
                    "      \"geo\": {\n" +
                    "        \"lat\": \"-37.3159\",\n" +
                    "        \"lng\": \"81.1496\"\n" +
                    "      }\n" +
                    "    },\n" +
                    "    \"phone\": \"1-770-736-8031 x56442\",\n" +
                    "    \"website\": \"hildegard.org\",\n" +
                    "    \"company\": {\n" +
                    "      \"name\": \"Romaguera-Crona\",\n" +
                    "      \"catchPhrase\": \"Multi-layered client-server neural-net\",\n" +
                    "      \"bs\": \"harness real-time e-markets\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 2,\n" +
                    "    \"name\": \"Ervin Howell\",\n" +
                    "    \"username\": \"Antonette\",\n" +
                    "    \"email\": \"Shanna@melissa.tv\",\n" +
                    "    \"address\": {\n" +
                    "      \"street\": \"Victor Plains\",\n" +
                    "      \"suite\": \"Suite 879\",\n" +
                    "      \"city\": \"Wisokyburgh\",\n" +
                    "      \"zipcode\": \"90566-7771\",\n" +
                    "      \"geo\": {\n" +
                    "        \"lat\": \"-43.9509\",\n" +
                    "        \"lng\": \"-34.4618\"\n" +
                    "      }\n" +
                    "    },\n" +
                    "    \"phone\": \"010-692-6593 x09125\",\n" +
                    "    \"website\": \"anastasia.net\",\n" +
                    "    \"company\": {\n" +
                    "      \"name\": \"Deckow-Crist\",\n" +
                    "      \"catchPhrase\": \"Proactive didactic contingency\",\n" +
                    "      \"bs\": \"synergize scalable supply-chains\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 3,\n" +
                    "    \"name\": \"Clementine Bauch\",\n" +
                    "    \"username\": \"Samantha\",\n" +
                    "    \"email\": \"Nathan@yesenia.net\",\n" +
                    "    \"address\": {\n" +
                    "      \"street\": \"Douglas Extension\",\n" +
                    "      \"suite\": \"Suite 847\",\n" +
                    "      \"city\": \"McKenziehaven\",\n" +
                    "      \"zipcode\": \"59590-4157\",\n" +
                    "      \"geo\": {\n" +
                    "        \"lat\": \"-68.6102\",\n" +
                    "        \"lng\": \"-47.0653\"\n" +
                    "      }\n" +
                    "    },\n" +
                    "    \"phone\": \"1-463-123-4447\",\n" +
                    "    \"website\": \"ramiro.info\",\n" +
                    "    \"company\": {\n" +
                    "      \"name\": \"Romaguera-Jacobson\",\n" +
                    "      \"catchPhrase\": \"Face to face bifurcated interface\",\n" +
                    "      \"bs\": \"e-enable strategic applications\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 4,\n" +
                    "    \"name\": \"Patricia Lebsack\",\n" +
                    "    \"username\": \"Karianne\",\n" +
                    "    \"email\": \"Julianne.OConner@kory.org\",\n" +
                    "    \"address\": {\n" +
                    "      \"street\": \"Hoeger Mall\",\n" +
                    "      \"suite\": \"Apt. 692\",\n" +
                    "      \"city\": \"South Elvis\",\n" +
                    "      \"zipcode\": \"53919-4257\",\n" +
                    "      \"geo\": {\n" +
                    "        \"lat\": \"29.4572\",\n" +
                    "        \"lng\": \"-164.2990\"\n" +
                    "      }\n" +
                    "    },\n" +
                    "    \"phone\": \"493-170-9623 x156\",\n" +
                    "    \"website\": \"kale.biz\",\n" +
                    "    \"company\": {\n" +
                    "      \"name\": \"Robel-Corkery\",\n" +
                    "      \"catchPhrase\": \"Multi-tiered zero tolerance productivity\",\n" +
                    "      \"bs\": \"transition cutting-edge web services\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 5,\n" +
                    "    \"name\": \"Chelsey Dietrich\",\n" +
                    "    \"username\": \"Kamren\",\n" +
                    "    \"email\": \"Lucio_Hettinger@annie.ca\",\n" +
                    "    \"address\": {\n" +
                    "      \"street\": \"Skiles Walks\",\n" +
                    "      \"suite\": \"Suite 351\",\n" +
                    "      \"city\": \"Roscoeview\",\n" +
                    "      \"zipcode\": \"33263\",\n" +
                    "      \"geo\": {\n" +
                    "        \"lat\": \"-31.8129\",\n" +
                    "        \"lng\": \"62.5342\"\n" +
                    "      }\n" +
                    "    },\n" +
                    "    \"phone\": \"(254)954-1289\",\n" +
                    "    \"website\": \"demarco.info\",\n" +
                    "    \"company\": {\n" +
                    "      \"name\": \"Keebler LLC\",\n" +
                    "      \"catchPhrase\": \"User-centric fault-tolerant solution\",\n" +
                    "      \"bs\": \"revolutionize end-to-end systems\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 6,\n" +
                    "    \"name\": \"Mrs. Dennis Schulist\",\n" +
                    "    \"username\": \"Leopoldo_Corkery\",\n" +
                    "    \"email\": \"Karley_Dach@jasper.info\",\n" +
                    "    \"address\": {\n" +
                    "      \"street\": \"Norberto Crossing\",\n" +
                    "      \"suite\": \"Apt. 950\",\n" +
                    "      \"city\": \"South Christy\",\n" +
                    "      \"zipcode\": \"23505-1337\",\n" +
                    "      \"geo\": {\n" +
                    "        \"lat\": \"-71.4197\",\n" +
                    "        \"lng\": \"71.7478\"\n" +
                    "      }\n" +
                    "    },\n" +
                    "    \"phone\": \"1-477-935-8478 x6430\",\n" +
                    "    \"website\": \"ola.org\",\n" +
                    "    \"company\": {\n" +
                    "      \"name\": \"Considine-Lockman\",\n" +
                    "      \"catchPhrase\": \"Synchronised bottom-line interface\",\n" +
                    "      \"bs\": \"e-enable innovative applications\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 7,\n" +
                    "    \"name\": \"Kurtis Weissnat\",\n" +
                    "    \"username\": \"Elwyn.Skiles\",\n" +
                    "    \"email\": \"Telly.Hoeger@billy.biz\",\n" +
                    "    \"address\": {\n" +
                    "      \"street\": \"Rex Trail\",\n" +
                    "      \"suite\": \"Suite 280\",\n" +
                    "      \"city\": \"Howemouth\",\n" +
                    "      \"zipcode\": \"58804-1099\",\n" +
                    "      \"geo\": {\n" +
                    "        \"lat\": \"24.8918\",\n" +
                    "        \"lng\": \"21.8984\"\n" +
                    "      }\n" +
                    "    },\n" +
                    "    \"phone\": \"210.067.6132\",\n" +
                    "    \"website\": \"elvis.io\",\n" +
                    "    \"company\": {\n" +
                    "      \"name\": \"Johns Group\",\n" +
                    "      \"catchPhrase\": \"Configurable multimedia task-force\",\n" +
                    "      \"bs\": \"generate enterprise e-tailers\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 8,\n" +
                    "    \"name\": \"Nicholas Runolfsdottir V\",\n" +
                    "    \"username\": \"Maxime_Nienow\",\n" +
                    "    \"email\": \"Sherwood@rosamond.me\",\n" +
                    "    \"address\": {\n" +
                    "      \"street\": \"Ellsworth Summit\",\n" +
                    "      \"suite\": \"Suite 729\",\n" +
                    "      \"city\": \"Aliyaview\",\n" +
                    "      \"zipcode\": \"45169\",\n" +
                    "      \"geo\": {\n" +
                    "        \"lat\": \"-14.3990\",\n" +
                    "        \"lng\": \"-120.7677\"\n" +
                    "      }\n" +
                    "    },\n" +
                    "    \"phone\": \"586.493.6943 x140\",\n" +
                    "    \"website\": \"jacynthe.com\",\n" +
                    "    \"company\": {\n" +
                    "      \"name\": \"Abernathy Group\",\n" +
                    "      \"catchPhrase\": \"Implemented secondary concept\",\n" +
                    "      \"bs\": \"e-enable extensible e-tailers\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 9,\n" +
                    "    \"name\": \"Glenna Reichert\",\n" +
                    "    \"username\": \"Delphine\",\n" +
                    "    \"email\": \"Chaim_McDermott@dana.io\",\n" +
                    "    \"address\": {\n" +
                    "      \"street\": \"Dayna Park\",\n" +
                    "      \"suite\": \"Suite 449\",\n" +
                    "      \"city\": \"Bartholomebury\",\n" +
                    "      \"zipcode\": \"76495-3109\",\n" +
                    "      \"geo\": {\n" +
                    "        \"lat\": \"24.6463\",\n" +
                    "        \"lng\": \"-168.8889\"\n" +
                    "      }\n" +
                    "    },\n" +
                    "    \"phone\": \"(775)976-6794 x41206\",\n" +
                    "    \"website\": \"conrad.com\",\n" +
                    "    \"company\": {\n" +
                    "      \"name\": \"Yost and Sons\",\n" +
                    "      \"catchPhrase\": \"Switchable contextually-based project\",\n" +
                    "      \"bs\": \"aggregate real-time technologies\"\n" +
                    "    }\n" +
                    "  },\n" +
                    "  {\n" +
                    "    \"id\": 10,\n" +
                    "    \"name\": \"Clementina DuBuque\",\n" +
                    "    \"username\": \"Moriah.Stanton\",\n" +
                    "    \"email\": \"Rey.Padberg@karina.biz\",\n" +
                    "    \"address\": {\n" +
                    "      \"street\": \"Kattie Turnpike\",\n" +
                    "      \"suite\": \"Suite 198\",\n" +
                    "      \"city\": \"Lebsackbury\",\n" +
                    "      \"zipcode\": \"31428-2261\",\n" +
                    "      \"geo\": {\n" +
                    "        \"lat\": \"-38.2386\",\n" +
                    "        \"lng\": \"57.2232\"\n" +
                    "      }\n" +
                    "    },\n" +
                    "    \"phone\": \"024-648-3804\",\n" +
                    "    \"website\": \"ambrose.net\",\n" +
                    "    \"company\": {\n" +
                    "      \"name\": \"Hoeger LLC\",\n" +
                    "      \"catchPhrase\": \"Centralized empowering task-force\",\n" +
                    "      \"bs\": \"target end-to-end models\"\n" +
                    "    }\n" +
                    "  }\n" +
                    "]\n");
            for(int i=0;i<jr.length();i++)
            {

                JSONObject jsonObject = jr.getJSONObject(i);
                String id = jsonObject.getString("id");
                String name = jsonObject.getString("name");
                String username = jsonObject.getString("username");
               // contactname = username;

                String email = jsonObject.getString("email");
                String phone = jsonObject.getString("phone");
               // phonenumber = phone;
                String website = jsonObject.getString("website");
                JSONObject address = jsonObject.getJSONObject("address");
                String street = address.getString("street");
                String suite = address.getString("suite");
                String city = address.getString("city");
                String zipcode = address.getString("zipcode");
                JSONObject geo = address.getJSONObject("geo");
                Double lat = Double.valueOf(geo.getString("lat"));
                Double lng = Double.valueOf(geo.getString("lng"));
                idlist.add(id);
               // rowid.add()
                rowname.add(name);
                rowusername.add(username);
                rowemail.add(email);
                rowstreet.add(street);
                rowsuite.add(suite);
                rowcity.add(city);
                rowzipcode.add(zipcode);

                rowphone.add(phone);
                rowwebsite.add(website);

                String full_address = street + "" + suite+""+zipcode;


            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();
        int rawContactID = idlist.size();

        for(int i=0;i<idlist.size();i++){
            ops.add(ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI)
                    .withValue(ContactsContract.RawContacts.ACCOUNT_TYPE, null)
                    .withValue(ContactsContract.RawContacts.ACCOUNT_NAME, null)
                    .build());

            ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                    .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, i)
                    .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE)
                    .withValue(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME,rowusername.get(i))
                    .build());

            ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                    .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, i)
                    .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE)
                    .withValue(ContactsContract.CommonDataKinds.Phone.NUMBER, rowphone.get(i))
                    .withValue(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE)
                    .build());

            ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                    .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, i)
                    .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE)
                    .withValue(ContactsContract.CommonDataKinds.StructuredPostal.STREET, rowstreet.get(i))
                    .build());

            ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                    .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, i)
                    .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE)
                    .withValue(ContactsContract.CommonDataKinds.StructuredPostal.CITY, rowcity.get(i))
                    .build());

            ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                    .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, i)
                    .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE)
                    .withValue(ContactsContract.CommonDataKinds.StructuredPostal.POSTCODE, rowzipcode.get(i))
                    .build());

            ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                    .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, i)
                    .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE)
                    .withValue(ContactsContract.CommonDataKinds.StructuredPostal.REGION, rowsuite.get(i))
                    .build());

            ops.add(ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI)
                    .withValueBackReference(ContactsContract.Data.RAW_CONTACT_ID, i)
                    .withValue(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE)
                    .withValue(ContactsContract.CommonDataKinds.Email.ADDRESS, rowemail.get(i))
                    .withValue(ContactsContract.CommonDataKinds.Email.TYPE, ContactsContract.CommonDataKinds.Email.TYPE_HOME)
                    .build());

            try {
                getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (OperationApplicationException e) {
                e.printStackTrace();
            }
           // rawContactID = rawContactID+1;
        }

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
