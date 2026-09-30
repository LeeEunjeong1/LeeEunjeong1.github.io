package io.github.leeeunjeong1.portfolio.data.local

class PortfolioLocalDataSource {
    internal fun getPortfolio(): PortfolioEntity = PortfolioEntity(
        name = "이은정",
        headline = "서비스는 멈추지 않게,\n레거시는 머무르지 않게.",
        introduction = "안녕하세요, 사용자 경험과 오래 유지되는 구조를 함께 고민하는 Android 개발자 이은정입니다.",
        about = "약 5년간 Android Native 앱을 개발하며 서비스 출시·운영, 성능 최적화, 아키텍처 개선을 경험했습니다. Kotlin과 Jetpack Compose를 중심으로 안정적이고 확장 가능한 제품을 만듭니다.",
        skills = listOf(
            "Kotlin", "Jetpack Compose", "Compose Multiplatform", "Android",
            "MVI", "Multi-module", "Coroutines", "Flow", "Hilt", "ExoPlayer",
        ),
        experiences = listOf(
            ExperienceEntity(
                company = "오토위니",
                role = "Android Developer",
                period = "2023.12 — Present",
                description = "글로벌 중고차 거래 서비스의 성능과 구조를 개선하고, Compose 기반 영상·콘텐츠 경험을 개발합니다.",
            ),
            ExperienceEntity(
                company = "씨비파이낸셜솔루션",
                role = "Android Developer",
                period = "2021.09 — 2023.11",
                description = "위치 기반 SNS와 금융상품 비교 앱의 설계, 출시, 운영 및 하이브리드 전환을 담당했습니다.",
            ),
        ),
        projects = listOf(
            ProjectEntity(
                id = "moazip",
                name = "moaZip",
                description = "관심 있는 정보와 콘텐츠를 한곳에 모아 관리하는 Android 애플리케이션입니다.",
                tags = listOf("Kotlin", "Compose", "MVI"),
                period = "개인 프로젝트",
                role = "Android 개발 · 기획 · 디자인",
                overview = "흩어진 링크와 콘텐츠를 주제별로 모으고 다시 찾기 쉽게 정리하는 개인 Android 프로젝트입니다.",
                highlights = listOf(
                    "Jetpack Compose 기반 선언형 UI 구성",
                    "단방향 데이터 흐름을 적용한 MVI 구조",
                    "기능 단위로 확장하기 쉬운 모듈 구조 설계",
                ),
                githubUrl = "https://github.com/LeeEunjeong1/moaZip",
            ),
            ProjectEntity(
                id = "kmp-portfolio",
                name = "KMP Portfolio",
                description = "Android, iOS, Web이 하나의 UI를 공유하는 Compose Multiplatform 포트폴리오입니다.",
                tags = listOf("KMP", "Wasm", "Responsive UI"),
                period = "2026",
                role = "KMP 개발 · 설계 · 배포",
                overview = "공통 UI와 데이터를 여러 플랫폼에서 공유하고 GitHub Pages로 자동 배포하는 반응형 포트폴리오입니다.",
                highlights = listOf(
                    "Compose Multiplatform 공통 UI 구현",
                    "멀티모듈과 클린 아키텍처 적용",
                    "Kotlin/Wasm 빌드 및 GitHub Pages 자동 배포",
                ),
                githubUrl = "https://github.com/LeeEunjeong1/LeeEunjeong1.github.io",
                serviceUrl = "https://leeeunjeong1.github.io",
            ),
        ),
        githubUrl = "https://github.com/LeeEunjeong1",
        blogUrl = "https://dev-ej2.tistory.com/",
        emailUrl = "mailto:tbig1019@gmail.com",
    )
}
