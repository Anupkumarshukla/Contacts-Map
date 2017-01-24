package lbmf.project.com.contacts_map;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AllContacts extends Fragment {
	ArrayList<SelectUser> selectUsers;
	List<SelectUser> temp;
	Cursor phones, email;
	ContentResolver resolver;
	SelectUserAdapter adapter;
	private ListView listView;
	private int bootCounter=0;
	private int maxRecords = 400;
	@Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
								 Bundle savedInstanceState) {
	 
	        View rootview = inflater.inflate(R.layout.tab1_frag, container, false);
		listView = (ListView) rootview.findViewById(R.id.contacts_list);

		selectUsers = new ArrayList<SelectUser>();
		resolver = getActivity().getContentResolver();
		listView = (ListView)rootview.findViewById(R.id.contacts_list);
		// gson = new Gson();
		phones = getActivity().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC");
		LoadContact loadContact = new LoadContact();
		loadContact.execute();
	       // ((TextView)rootview.findViewById(R.id.textView)).setText("AllContacts");

	/*	listView.setHasMoreItems(true);
		listView.setPagingableListener(new PagingListView.Pagingable() {
			@Override
			public void onLoadMoreItems() {
				if (pager < 3) {
					new CountryAsyncTask(false).execute();
				} else {
					listView.onFinishLoading(false, null);
				}
			}
		});*/

		listView.setOnScrollListener(new AbsListView.OnScrollListener() {
			@Override
			public void onScrollStateChanged(AbsListView absListView, int i) {

			}

			@Override
			public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
				if(firstVisibleItem+visibleItemCount > totalItemCount-2 && totalItemCount < maxRecords){
					//adapter.add(bootData());
					adapter.notifyDataSetChanged();
				}
			}
		});



		listView.setOnScrollListener(new EndlessScrollListener() {
			@Override
			public void onLoadMore(int page, int totalItemsCount) {

			}
		});
	        return rootview;
}

	/*private List<SelectUser> bootData(){
		List<SelectUser> persons = new ArrayList<SelectUser>();
		for(int i=bootCounter;i<bootCounter+20;i++){
			SelectUser person = new SelectUser();
			person.setName();
			person.setDesc("description :" + i);
			person.setEmail("person" + i + "@ekiras.com");
			person.setImage(R.drawable.user);
			persons.add(person);
		}
		bootCounter+=20;
		return persons;
	}*/

	class LoadContact extends AsyncTask<Void, Void, Void> {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();

		}

		@Override
		protected Void doInBackground(Void... voids) {
			// Get Contact list from Phone

			if (phones != null) {
				Log.e("count", "" + phones.getCount());
				if (phones.getCount() == 0) {
					Toast.makeText(getActivity(), "No contacts in your contact list.", Toast.LENGTH_LONG).show();
				}

				while (phones.moveToNext()) {
					Bitmap bit_thumb = null;
					String id = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID));
					String name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
					String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
					String EmailAddr = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA2));
                   /*// String image_thumb = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_THUMBNAIL_URI));
                    try {
                        if (image_thumb != null) {
                            bit_thumb = MediaStore.Images.Media.getBitmap(resolver, Uri.parse(image_thumb));
                        } else {
                            Log.e("No Image Thumb", "--------------");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }*/

					SelectUser selectUser = new SelectUser();
					selectUser.setThumb(bit_thumb);
					selectUser.setName(name);
					selectUser.setPhone(phoneNumber);
					selectUser.setEmail(id);
					selectUser.setCheckedBox(false);
					selectUsers.add(selectUser);
				}
			} else {
				Log.e("Cursor close 1", "----------------");
			}
			//phones.close();
			return null;
		}

		@Override
		protected void onPostExecute(Void aVoid) {
			super.onPostExecute(aVoid);
			adapter = new SelectUserAdapter(selectUsers, getActivity());
			listView.setAdapter(adapter);

			// Select item on listclick
			listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

					Log.e("search", "here---------------- listener");

					SelectUser data = selectUsers.get(i);
				}
			});

			listView.setFastScrollEnabled(true);
		}
	}



	public abstract class EndlessScrollListener implements AbsListView.OnScrollListener {
		// The minimum amount of items to have below your current scroll position
		// before loading more.
		private int visibleThreshold = 5;
		// The current offset index of data you have loaded
		private int currentPage = 0;
		// The total number of items in the dataset after the last load
		private int previousTotalItemCount = 0;
		// True if we are still waiting for the last set of data to load.
		private boolean loading = true;
		// Sets the starting page index
		private int startingPageIndex = 0;

		public EndlessScrollListener() {
		}

		public EndlessScrollListener(int visibleThreshold) {
			this.visibleThreshold = visibleThreshold;
		}

		public EndlessScrollListener(int visibleThreshold, int startPage) {
			this.visibleThreshold = visibleThreshold;
			this.startingPageIndex = startPage;
			this.currentPage = startPage;
		}

		// This happens many times a second during a scroll, so be wary of the code you place here.
		// We are given a few useful parameters to help us work out if we need to load some more data,
		// but first we check if we are waiting for the previous load to finish.
		@Override
		public void onScroll(AbsListView view,int firstVisibleItem,int visibleItemCount,int totalItemCount) {
			// If the total item count is zero and the previous isn't, assume the
			// list is invalidated and should be reset back to initial state
			if (totalItemCount < previousTotalItemCount) {
				this.currentPage = this.startingPageIndex;
				this.previousTotalItemCount = totalItemCount;
				if (totalItemCount == 0) { this.loading = true; }
			}

			// If it’s still loading, we check to see if the dataset count has
			// changed, if so we conclude it has finished loading and update the current page
			// number and total item count.
			if (loading && (totalItemCount > previousTotalItemCount)) {
				loading = false;
				previousTotalItemCount = totalItemCount;
				currentPage++;
			}

			// If it isn’t currently loading, we check to see if we have breached
			// the visibleThreshold and need to reload more data.
			// If we do need to reload some more data, we execute onLoadMore to fetch the data.
			if (!loading && (totalItemCount - visibleItemCount)<=(firstVisibleItem + visibleThreshold)) {
				onLoadMore(currentPage + 1, totalItemCount);
				loading = true;
			}
		}

		// Defines the process for actually loading more data based on page
		public abstract void onLoadMore(int page, int totalItemsCount);

		@Override
		public void onScrollStateChanged(AbsListView view, int scrollState) {
			// Don't take any action on changed
		}
	}
}
