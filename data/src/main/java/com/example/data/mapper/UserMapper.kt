package com.example.data.mapper

import com.example.data.model.RepositoryDTO
import com.example.data.model.UserDTO
import com.example.data.model.UserDetailDTO
import com.example.domain.model.RepositoryDomainModel
import com.example.domain.model.UserDetailDomainModel
import com.example.domain.model.UserDomainModel
import javax.inject.Inject

class UserMapper @Inject constructor() {
    fun mapToUser(usersList: List<UserDTO>): List<UserDomainModel> {
        return usersList.map {
            UserDomainModel(
                userId = it.userId,
                avatarUrl = it.avatarUrl
            )
        }
    }

    fun mapToUserDetail(userDetailDTO: UserDetailDTO): UserDetailDomainModel {
        return UserDetailDomainModel(
            avatarUrl = userDetailDTO.avatarUrl,
            name = userDetailDTO.name,
            location = userDetailDTO.location,
            blogUrl = userDetailDTO.blogUrl,
            publicRepos = userDetailDTO.publicRepos,
            followers = userDetailDTO.followers,
            following = userDetailDTO.following

        )
    }

    fun mapToUserRepos(repos: List<RepositoryDTO>): List<RepositoryDomainModel> {
        return repos.map {
            RepositoryDomainModel(
                id = it.id,
                name = it.name,
                description = it.description,
                watchersCount = it.watchersCount,
                forksCount = it.forksCount,
                language = it.language
            )
        }

    }

}
