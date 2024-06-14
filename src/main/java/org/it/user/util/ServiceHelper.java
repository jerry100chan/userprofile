package org.it.user.util;

import lombok.extern.slf4j.Slf4j;
import org.it.user.entity.Post;
import org.it.user.entity.Profile;
import org.it.user.entity.Result;
import org.it.user.entity.UserInfo;
import org.it.user.service.PostService;
import org.it.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ServiceHelper {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private PostService postService;

    public Result<Object> getProfiles() {
        // request for getting user basic info list
        Future<ResponseEntity<List<UserInfo>>> userInfoListFuture = userInfoService.getUserInfoListFuture();
        // request for getting user post list
        Future<ResponseEntity<List<Post>>> postListFuture = postService.getPostListFuture();
        List<UserInfo> userInfoList = userInfoService.getUserInfoList(userInfoListFuture);
        List<Post> postList = postService.getPostListEntity(postListFuture);

        List<Profile> profileList = createProfiles(postList, userInfoList);

        Result<Object> result = Result.success();
        result.setData(profileList);

        return result;
    }

    private List<Profile> createProfiles(List<Post> postList, List<UserInfo> userInfoList) {
        Map<Long, Post> postMap = postList.stream().collect(Collectors.toMap(Post::getId, u -> u));
        List<Profile> profileList = new ArrayList<>();
        for (UserInfo userInfo : userInfoList) {
            Profile profile = new Profile();
            Long id = userInfo.getId();
            Post post = postMap.get(id);
            profile = profile.buildWithUserInfo(userInfo).buildWithPost(post);
            profileList.add(profile);
        }
        return profileList;
    }

}

