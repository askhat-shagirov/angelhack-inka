package com.angelhack.inka.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angelhack.inka.common.ItemCategory;
import com.angelhack.inka.dto.DiscountDto;
import com.angelhack.inka.dto.StoreDto;
import com.angelhack.inka.dto.StoreSearchResultDto;
import com.angelhack.inka.dto.StoreSearchResultDto.SearchResultItemDto;
import com.angelhack.inka.dto.StoreSearchResultDto.SearchResultWishDto;
import com.angelhack.inka.entity.DiscountEntity;
import com.angelhack.inka.entity.ItemEntity;
import com.angelhack.inka.entity.SellerEntity;
import com.angelhack.inka.entity.StoreEntity;
import com.angelhack.inka.entity.UserEntity;
import com.angelhack.inka.entity.WishlistEntity;
import com.angelhack.inka.repository.SellerRepository;
import com.angelhack.inka.repository.StoreRepository;
import com.angelhack.inka.security.SecurityService;
import com.angelhack.inka.service.DiscountService;
import com.angelhack.inka.service.StoreService;
import com.angelhack.inka.service.google.GooglePlaceService;
import com.angelhack.inka.util.GeoUtil;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {
	
	@Autowired
	SecurityService securityService;

    @Autowired
    private StoreRepository storeRepository;
    
    @Autowired
    SellerRepository sellerRepository;
    
    @Autowired
    private GooglePlaceService googlePlaceService;
    
    @Autowired
    DiscountService discountService;

    @Override
    public List<StoreEntity> getAll() {
        return storeRepository.findAll();
    }

    @Override
    public StoreEntity save(StoreEntity test) {
        return storeRepository.save(test);
    }
    
    @Override
    public StoreSearchResultDto findNearByStores(double lon, double lat, double radius){
    	UserEntity user = securityService.getCurrentUser();
    	List<ItemCategory> storeTypes = new ArrayList<ItemCategory>();
    	List<ItemEntity> userItems = new ArrayList<ItemEntity>();
    	
    	
    	List<SearchResultWishDto> searchResultWishes = new ArrayList<SearchResultWishDto>();
    	SearchResultWishDto currWishResultDto = null;
    	List<SearchResultItemDto> currentItemsResultDto = null;
    	for(WishlistEntity wishListItem : user.getWishlists()){
    		currentItemsResultDto = new ArrayList<SearchResultItemDto>();
    		
    		List<StoreDto> storeSearchResult = null;
    		SearchResultItemDto currSearchResultItem = null;
    		for(ItemEntity item : wishListItem.getItems()){
    			storeSearchResult = getNearestStoreWithDiscount(item, lon, lat, radius);
    			if(storeSearchResult != null && !storeSearchResult.isEmpty()){
    				currSearchResultItem = new SearchResultItemDto(item);
    				currentItemsResultDto.add(currSearchResultItem);
    			}
    		}
    		
    		if(!currentItemsResultDto.isEmpty()){
    			searchResultWishes.add(currWishResultDto);
    		}
    	}
    	
    	StoreSearchResultDto result = new StoreSearchResultDto();
    	result.setResultWishDtos(searchResultWishes);  	

    	return result;
    }
    
    private List<StoreDto> getNearestStoreWithDiscount(ItemEntity item, double lon, double lat, double radius){
    	Map<Long,DiscountEntity> discMap = getDiscountMap(item);
    	List<StoreEntity> stores = getNearestStores(item, lon, lat, radius);
    	
    	List<StoreDto> storeSearchResult = new ArrayList<StoreDto>();
    	DiscountEntity currDiscount = null;
    	StoreDto currStoreResultDto = null;
    	for(StoreEntity store: stores){
    		currStoreResultDto = new StoreDto(store);
    		currDiscount = discMap.get(store.getSeller().getId());
    		
    		if(currDiscount != null) currStoreResultDto.addDiscounts(new DiscountDto(currDiscount));
    		storeSearchResult.add(currStoreResultDto);
    	}
    	
    	storeSearchResult.addAll(googlePlaceService.getStoresNearby(lat, lon, radius, item.getCategories()));
    	return storeSearchResult;
    }
    
    
    private List<StoreEntity> getNearestStores(ItemEntity item, double lon, double lat, double radius){
    	List<SellerEntity> sellers = sellerRepository.findByCategoriesIn(item.getCategories());
    	List<StoreEntity> stores = new ArrayList<StoreEntity>();    	
    	for(SellerEntity seller : sellers){
    		stores.addAll(seller.getStores());
    	}
    	return filterStoresByVicinity(lon, lat, radius, stores);
    }
    
    private Map<Long,DiscountEntity> getDiscountMap(ItemEntity item){
    	Map<Long,DiscountEntity> discMap = new HashMap<Long, DiscountEntity>();
    	for(DiscountEntity disc : item.getDiscounts()){
    		discMap.put(disc.getSeller().getId(), disc);
    	}
    	return discMap;
    }
    
   /* private List<ItemCategory> getStoreTypes(UserEntity user){
    	List<ItemCategory> storeTypes = new ArrayList<ItemCategory>();
    	
    	for(WishlistEntity wishListItem : user.getWishlists()){
    		for(ItemEntity item : wishListItem.getItems()){
    			storeTypes.addAll(item.getCategories());
    		}
    	}
    	
    	return storeTypes;
    }
    
    private List<StoreDto> filterStoresByVicinity(double longitude, double latitude, double radius, List<StoreEntity> stores){
    	List<StoreDto> filteredStores = new ArrayList<StoreDto>();
    	double currDist = 0;
    	StoreDto currStoreDTO = null;
    	for(StoreEntity store : stores){
    		currDist = GeoUtil.getDistance(latitude, longitude, store.getLatitude(), store.getLongitude());
    		if(currDist <= radius){
    			currStoreDTO = new StoreDto(store);
    			//currStoreDTO.setDistance(currDist);
    			filteredStores.add(currStoreDTO);
    		}
    	}
    	return filteredStores;
    }*/
    
    private List<StoreEntity> filterStoresByVicinity(double longitude, double latitude, double radius, List<StoreEntity> stores){
    	List<StoreEntity> filteredStores = new ArrayList<StoreEntity>();
    	double currDist = 0;
    	//StoreDto currStoreDTO = null;
    	for(StoreEntity store : stores){
    		currDist = GeoUtil.getDistance(latitude, longitude, store.getLatitude(), store.getLongitude());
    		if(currDist <= radius){
    			//currStoreDTO = new StoreDto(store);
    			//currStoreDTO.setDistance(currDist);
    			filteredStores.add(store);
    		}
    	}
    	return filteredStores;
    }
    
    /*public StoreSearchResultDto convert(List<StoreEntity> stores){
    	StoreSearchResultDto searchResultDto = new StoreSearchResultDto();
    	for(StoreEntity store : stores){
    		searchResultDto.addStore(new StoreDto(store));
    	}
    	return searchResultDto;
    }*/
}